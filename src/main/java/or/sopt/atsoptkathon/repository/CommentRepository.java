package or.sopt.atsoptkathon.repository;

import or.sopt.atsoptkathon.domain.Comment;
import or.sopt.atsoptkathon.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByProduct(Product product);
}
