package study.sns.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Ban extends TimeBaseEntity {

    @Id @GeneratedValue
    @Column(name = "ban_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "created_by")
    private Profile createdBy;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "target_by")
    private Profile targetBy;
}
