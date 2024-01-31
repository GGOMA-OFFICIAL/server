package ggoma.ggoma.dto;

/*import lombok.Builder;*/
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginRequestDTO {

    private String kNickname;
    private String memberNumber;


/*    @Builder
    public LoginRequestDTO(String kNickname, String memberNumber){
        this.kNickname = kNickname;
        this.memberNumber = memberNumber;
    }*/
}
