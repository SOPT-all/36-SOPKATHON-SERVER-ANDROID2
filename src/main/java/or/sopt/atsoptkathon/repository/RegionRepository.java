package or.sopt.atsoptkathon.repository;

import or.sopt.atsoptkathon.domain.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegionRepository extends JpaRepository<Region, Long> {
    Optional<Region> findById(Long id);
}
