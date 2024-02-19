package ggoma.ggoma.service;

import ggoma.ggoma.dto.JwtTokenResponseDTO;
import ggoma.ggoma.jwt.JwtTokenProvider;
import ggoma.ggoma.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*

import ggoma.ggoma.dto.JoinRequestDTO;
import ggoma.ggoma.dto.LoginRequestDTO;
import ggoma.ggoma.entity.UserEntity;
import ggoma.ggoma.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

*/
/*    public void join(JoinRequestDTO joinRequestDTO){
        userRepository.save(joinRequestDTO.toEntity());
    }*//*


    public UserEntity login(LoginRequestDTO loginRequestDTO){
        Optional<UserEntity> optionalUserEntity = userRepository.findByMemberNumber(loginRequestDTO.getMemberNumber());

        if(optionalUserEntity.isEmpty()){
            return null;
        }

        UserEntity userEntity = optionalUserEntity.get();

        return userEntity;
    }

    //login 여부에 따른 return 값 코드 재확인 필요
    public UserEntity getLoginUserByMemberNumber(String memberNumber){
//        if(memberNumber == null) return null;

        Optional<UserEntity> optionalUserEntity = userRepository.findByMemberNumber(memberNumber);

        if(optionalUserEntity.isEmpty()){
            UserEntity newUserEntity = new UserEntity();
            newUserEntity.setMemberNumber(memberNumber);
            userRepository.save(newUserEntity);

            return newUserEntity;
        }


        return optionalUserEntity.get();
    }
}
*/
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public JwtTokenResponseDTO login(String nickName, String memberNumber) {
        // 1. Login ID/PW 를 기반으로 Authentication 객체 생성
        // 이때 authentication 는 인증 여부를 확인하는 authenticated 값이 false
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(nickName, memberNumber);

        // 2. 실제 검증 (사용자 비밀번호 체크)이 이루어지는 부분
        // authenticate 매서드가 실행될 때 CustomUserDetailsService 에서 만든 loadUserByUsername 메서드가 실행
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        // 3. 인증 정보를 기반으로 JWT 토큰 생성
        JwtTokenResponseDTO jwtTokenResponseDTO = jwtTokenProvider.generateToken(authentication);

        return jwtTokenResponseDTO;
    }
}