package study.sns.service.memberservice;

import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface MemberQueryService {
}
