package ggoma.ggoma.controller;

import ggoma.ggoma.dto.JwtTokenResponseDTO;
import ggoma.ggoma.dto.LoginRequestDTO;
import ggoma.ggoma.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*

import ggoma.ggoma.dto.LoginRequestDTO;
import ggoma.ggoma.entity.UserEntity;
//import ggoma.ggoma.jwt.JwtTokenUtil;
import ggoma.ggoma.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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

        String secretKey = "e3a3f9aa7bfd221d40aab4e1112d3a00e70b76c02bf756d1b88225c573535e0a";

        // token 유효 시간(60분)
        long expireTimeMs = 1000 * 60 * 60;

        //MemberNumber 값을 SnsId 값으로 수정 필요!!!!!
//        String jwtToken = JwtTokenUtil.createToken(userEntity.getMemberNumber(), secretKey, expireTimeMs);

//        return jwtToken;
        return null;
    }
}*/
@Slf4j
@RestController
@RequiredArgsConstructor
//@RequestMapping("/member")
public class UserController {
    private final UserService userService;

    @PostMapping("/member")
    public JwtTokenResponseDTO login(@RequestBody LoginRequestDTO loginRequestDTO) {
        String nickName = loginRequestDTO.getNickName();
        String memberNumber = loginRequestDTO.getMemberNumber();
        JwtTokenResponseDTO jwtTokenResponseDTO = userService.login(nickName, memberNumber);
        return jwtTokenResponseDTO;
    }
}