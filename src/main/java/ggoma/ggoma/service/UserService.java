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

    public boolean login(LoginRequestDTO loginRequestDTO){
        Optional<UserEntity> optionalUserEntity = userRepository.findByMemberNumber(loginRequestDTO.getMemberNumber());

        if(optionalUserEntity.isEmpty()){
            return false;
        }

        return true;
    }
}
