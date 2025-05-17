package or.sopt.atsoptkathon.util;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import or.sopt.atsoptkathon.dto.ImageUploadResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class S3Util {

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;
    private final AmazonS3 amazonS3;


    public ImageUploadResponseDTO upload(String dirName, MultipartFile file) {

        String fileName = dirName + "/" + UUID.randomUUID() + "-" + file.getOriginalFilename();
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(file.getSize());
        metadata.setContentType(file.getContentType());

        String originalFileName = file.getOriginalFilename();

        try {
            log.info("이미지 업로드를 시작합니다");

            amazonS3.putObject(new PutObjectRequest(bucket, fileName, file.getInputStream(), metadata));
            log.info("이미지가 성공적으로 업로드 되었습니다");
        } catch (AmazonServiceException e) {
            throw new IllegalArgumentException("이미지 업로드에 실패하였습니다: " + fileName, e);
        } catch (Exception e) {
            throw new RuntimeException("이미지 업로드에 실패하였습니다: " + e.getMessage(), e);
        }

        return ImageUploadResponseDTO.from(fileName,originalFileName,amazonS3.getUrl(bucket, fileName).toString());
    }
}

