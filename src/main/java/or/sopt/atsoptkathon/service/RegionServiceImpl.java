package or.sopt.atsoptkathon.service;

import lombok.RequiredArgsConstructor;
import or.sopt.atsoptkathon.domain.Region;
import or.sopt.atsoptkathon.domain.RegionImage;
import or.sopt.atsoptkathon.dto.GetRegionDetailDTO;
import or.sopt.atsoptkathon.global.exception.handler.CustomHandler;
import or.sopt.atsoptkathon.global.status.ErrorStatus;
import or.sopt.atsoptkathon.repository.RegionImageRepository;
import or.sopt.atsoptkathon.repository.RegionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class RegionServiceImpl implements RegionService {

    private final RegionImageRepository regionImageRepository;
    private final RegionRepository regionRepository;


    @Override
    public GetRegionDetailDTO getRegionDetail(Long regionId) {
        Region region = regionRepository.findById(regionId)
                .orElseThrow(() -> new CustomHandler(ErrorStatus._REGION_NOT_FOUND));
        RegionImage regionImage = regionImageRepository.findByRegionId(regionId)
                .orElseThrow(() -> new CustomHandler(ErrorStatus._REGION_IMAGE_NOT_FOUND));


        return GetRegionDetailDTO.from(region, regionImage);
    }

}
