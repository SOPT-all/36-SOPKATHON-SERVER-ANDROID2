package or.sopt.atsoptkathon.repository;

import or.sopt.atsoptkathon.domain.Product;
import or.sopt.atsoptkathon.domain.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {

    List<ProductImage> findAllByProduct(Product product);
}
