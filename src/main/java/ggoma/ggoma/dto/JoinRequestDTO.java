package ggoma.ggoma.dto;

import ggoma.ggoma.entity.UserEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JoinRequestDTO {

    private Long snsId;

    private String kNickname;
    private String memberNumber;

    public UserEntity toEntity(){
        return UserEntity.builder()
                .kNickname(this.kNickname)
                .memberNumber(this.memberNumber)
                .build();
    }
}
