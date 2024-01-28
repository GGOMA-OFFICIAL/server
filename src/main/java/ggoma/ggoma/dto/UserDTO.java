package ggoma.ggoma.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserDTO {
    private Long k_nickname;
    private String member_number;
    private String access_token;
    private String refresh_token;

    @Builder
    public UserDTO(Long k_nickname, String member_number, String access_token, String refresh_token){
        this.k_nickname = k_nickname;
        this.member_number = member_number;
        this.access_token = access_token;
        this.refresh_token = refresh_token;
    }
}
