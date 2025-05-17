package or.sopt.atsoptkathon.repository;

import or.sopt.atsoptkathon.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
