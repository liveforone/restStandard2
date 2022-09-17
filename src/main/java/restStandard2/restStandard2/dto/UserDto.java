package restStandard2.restStandard2.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import restStandard2.restStandard2.domain.Role;
import restStandard2.restStandard2.domain.Users;

@Data
@NoArgsConstructor
public class UserDto {

    private Long id;
    private String email;
    private String password;
    private Role auth;

    //==dto -> entity==//
    public Users toEntity() {
        return Users.builder()
                .id(id)
                .email(email)
                .password(password)
                .auth(auth)
                .build();
    }
}
