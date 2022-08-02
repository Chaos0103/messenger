package study.sns.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Friend extends TimeBaseEntity {

    @Id @GeneratedValue
    @Column(name = "friend_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "created_by")
    private Profile createdBy;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "target_by")
    private Profile targetBy;
}
