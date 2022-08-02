package study.sns.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Profile extends TimeBaseEntity {

    @Id @GeneratedValue
    @Column(name = "profile_id")
    private Long id;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(nullable = false, length = 20)
    private String name;
    @Column(updatable = false, nullable = false, length = 20)
    private String searchId;
    @Column(length = 60)
    private String statusMessage;
}
