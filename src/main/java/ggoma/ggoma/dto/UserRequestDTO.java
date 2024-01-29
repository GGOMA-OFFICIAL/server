package ggoma.ggoma.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserRequestDTO {
    private Long kNickname;
    private String memberNumber;


    @Builder
    public UserRequestDTO(Long kNickname, String memberNumber){
        this.kNickname = kNickname;
        this.memberNumber = memberNumber;
    }
}
