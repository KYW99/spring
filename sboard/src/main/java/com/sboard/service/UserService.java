package com.sboard.service;

import com.sboard.dto.UserDTO;
import com.sboard.entity.User;
import com.sboard.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public void insertUser(UserDTO userDTO) {

        User entity = userDTO.toEntity();

        userRepository.save(entity);
    }

    // 사용자 ID가 사용 가능한지 확인
    public boolean isUserIdAvailable(String uid) {
        return !userRepository.existsByUid(uid);
    }

    // 별명이 사용 가능한지 확인
    public boolean isNicknameAvailable(String nick) {
        return !userRepository.existsByNick(nick);
    }

    // 이메일이 사용 가능한지 확인
    public boolean isEmailAvailable(String email) {
        return !userRepository.existsByEmail(email);
    }

    // 휴대폰 번호가 사용 가능한지 확인
    public boolean isPhoneNumberAvailable(String hp) {
        return !userRepository.existsByHp(hp);
    }


}
