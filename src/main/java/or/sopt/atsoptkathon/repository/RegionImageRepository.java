package or.sopt.atsoptkathon.repository;

import or.sopt.atsoptkathon.domain.Region;
import or.sopt.atsoptkathon.domain.RegionImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegionImageRepository extends JpaRepository<RegionImage, Long> {
    Optional<RegionImage> findByRegionId(Long regionId);

}
