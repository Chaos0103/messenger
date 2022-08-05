package study.sns.service.memberservice;

import org.springframework.transaction.annotation.Transactional;
import study.sns.dto.MemberDto;

@Transactional
public interface MemberBusinessService {

    /**
     * 회원가입
     * @return 회원 PK
     */
    Long joinMember(MemberDto memberDto);

    /**
     * 회원탈퇴
     */
    void withdrawal(Long memberId);

    /**
     * 회원수정 - password 수정 가능
     */
    void modifyPassword(Long memberId, String newPassword);
}
