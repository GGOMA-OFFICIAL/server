package ggoma.ggoma.dto;

/*import lombok.Builder;*/
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Data
public class LoginRequestDTO {

    private String nickName;
    private String memberNumber;


/*        @Builder
    public LoginRequestDTO(String kNickname, String memberNumber){
        this.kNickname = kNickname;
        this.memberNumber = memberNumber;
    }*/
}
