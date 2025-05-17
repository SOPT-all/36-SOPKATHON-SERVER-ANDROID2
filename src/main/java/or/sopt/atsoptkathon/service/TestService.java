package or.sopt.atsoptkathon.service;

import lombok.RequiredArgsConstructor;
import or.sopt.atsoptkathon.global.exception.handler.CustomHandler;
import or.sopt.atsoptkathon.global.status.ErrorStatus;
import or.sopt.atsoptkathon.util.S3Util;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class TestService {

    private final S3Util s3Util;

    public String test(String input){

        if (Objects.equals(input, "1")){
            throw new CustomHandler(ErrorStatus._TEST_EXCEPTION);
        }

        return "예외는 이렇게 처리해주세요";
    }

    public void testUpload(MultipartFile file){

        String dirname = "test";

        s3Util.upload(dirname, file);
    }
}
