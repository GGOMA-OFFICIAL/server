package ggoma.ggoma.service;

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

    public void join(JoinRequestDTO joinRequestDTO){
        userRepository.save(joinRequestDTO.toEntity());
    }

    //login 여부에 따른 return 값 코드 재확인 필요
    public UserEntity getLoginUserByMemberNumber(String memberNumber){
//        if(memberNumber == null) return null;

        Optional<UserEntity> optionalUserEntity = userRepository.findByMemberNumber(memberNumber);

        if(optionalUserEntity.isEmpty()){
            return null;
        }


        return optionalUserEntity.get();
    }
}
