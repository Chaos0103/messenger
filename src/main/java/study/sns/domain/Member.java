package study.sns.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends TimeBaseEntity {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(updatable = false, nullable = false, length = 50)
    private String email;
    @Column(nullable = false, length = 20)
    private String password;
    @Column(updatable = false, nullable = false, length = 20)
    private String name;
    @Column(updatable = false, nullable = false, length = 11)
    private String phone;

    public Member(String email, String password, String name, String phone) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
    }

    //==비즈니스 로직==//
    public void changePassword(String newPassword) {
        this.password = newPassword;
    }
}
