package ggoma.ggoma.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class JwtTokenResponseDTO {
    private String grantType;   //JWT에 대한 인증 타입
    private String accessToken;
    private String refreshToken;
}