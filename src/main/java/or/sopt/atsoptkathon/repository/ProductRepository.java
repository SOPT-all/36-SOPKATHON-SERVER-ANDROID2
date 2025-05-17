package or.sopt.atsoptkathon.repository;

import or.sopt.atsoptkathon.domain.Product;
import or.sopt.atsoptkathon.domain.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByRegion(Region region);
}
