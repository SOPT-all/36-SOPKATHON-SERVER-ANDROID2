package or.sopt.atsoptkathon.repository;

import or.sopt.atsoptkathon.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
