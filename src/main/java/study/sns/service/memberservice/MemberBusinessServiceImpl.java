package study.sns.service.memberservice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.sns.domain.Member;
import study.sns.dto.MemberDto;
import study.sns.exception.DuplicateException;
import study.sns.exception.NoSuchException;
import study.sns.repository.MemberRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberBusinessServiceImpl implements MemberBusinessService {

    private final MemberRepository memberRepository;

    @Override
    public Long joinMember(MemberDto memberDto) {
        validation(memberDto.getEmail(), memberDto.getPhone());

        Member member = createMember(memberDto);
        Member savedMember = memberRepository.save(member);

        return savedMember.getId();
    }

    @Override
    public void withdrawal(Long memberId) {
        Member findMember = findMemberEntity(memberId);

        memberRepository.delete(findMember);
    }

    @Override
    public void modifyPassword(Long memberId, String newPassword) {
        Member findMember = findMemberEntity(memberId);

        findMember.changePassword(newPassword);
    }

    private void validation(String email, String phone) {
        Optional<Member> findMember = memberRepository.findJoinByEmailOrPhone(email, phone);
        if (findMember.isPresent()) {
            throw new DuplicateException("이미 등록된 회원 정보입니다.");
        }
    }

    private static Member createMember(MemberDto memberDto) {
        return new Member(memberDto.getEmail(), memberDto.getPassword(), memberDto.getName(), memberDto.getPhone());
    }

    private Member findMemberEntity(Long memberId) {
        return memberRepository.findById(memberId).orElseThrow(() -> {
            throw new NoSuchException("등록되지 않은 회원입니다.");
        });
    }
}
