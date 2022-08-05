package study.sns.dto;

import lombok.Data;

@Data
public class MemberDto {

    private Long id;
    private String email;
    private String password;
    private String name;
    private String phone;
}
