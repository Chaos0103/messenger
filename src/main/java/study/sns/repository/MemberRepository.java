package study.sns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.sns.domain.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findJoinByEmailOrPhone(String email, String phone);
}
