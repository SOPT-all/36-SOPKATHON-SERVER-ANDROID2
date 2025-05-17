package or.sopt.atsoptkathon.dto;

import or.sopt.atsoptkathon.domain.Region;
import or.sopt.atsoptkathon.domain.RegionImage;

public record GetRegionDetailDTO(String regionName, String regionDescription, String regionImage) {
    public static GetRegionDetailDTO from(Region region, RegionImage regionImage) {
        return new GetRegionDetailDTO(
                region.getRegionName(),
                region.getRegionDescription(),
                regionImage.getImageLink()
        );
    }
}
