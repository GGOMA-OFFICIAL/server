package ggoma.ggoma.service;

import ggoma.ggoma.entity.UserEntity;
import ggoma.ggoma.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String nickName) throws UsernameNotFoundException {
        return userRepository.findByNickName(nickName)
                .map(this::createUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException("해당하는 유저를 찾을 수 없습니다."));
    }

    // 해당하는 User의 데이터가 존재한다면 UserDetails 객체로 만들어서 리턴
    private UserDetails createUserDetails(UserEntity userEntity) {
        // 사용자명(kNickname)과 패스워드(memberNumber)를 가져옵니다.
        String nickName = userEntity.getNickName();
        String memberNumber = userEntity.getMemberNumber();

        // User 객체를 생성하여 반환합니다.
        return User.builder()
                .username(nickName) // 사용자명으로 kNickname을 설정합니다.
                .password(memberNumber) // 패스워드로 memberNumber를 설정합니다.
                .roles() // 역할은 필요하지 않으므로 빈 값으로 설정합니다.
                .build();
    }

}