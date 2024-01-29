package ggoma.ggoma.controller;

import ggoma.ggoma.dto.LoginRequestDTO;
import ggoma.ggoma.entity.UserEntity;
import ggoma.ggoma.jwt.JwtTokenUtil;
import ggoma.ggoma.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class JwtLoginController {
    private final UserService userService;

    @PostMapping("/member")
    public String login(@RequestBody LoginRequestDTO loginRequestDTO){
        UserEntity userEntity = userService.login(loginRequestDTO);

        if(userEntity == null){
            return null;
        }

        String secretKey = "${JWT_SECRET}";

        // token 유효 시간(60분)
        long expireTimeMs = 1000 * 60 * 60;

        String jwtToken = JwtTokenUtil.createToken(userEntity.getMemberNumber(), secretKey, expireTimeMs);

        return jwtToken;
    }
}