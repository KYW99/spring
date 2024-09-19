package com.ch07.service;

import com.ch07.dto.User1DTO;
import com.ch07.entity.User1;
import com.ch07.repository.User1Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@RequiredArgsConstructor
@Service
public class User1Service {

    // 생성자 주입
    private final User1Repository user1Repository;


    public void insertUser1(User1DTO user1DTO) {

        // DTO를 Entity로 변환
        User1 entity = user1DTO.toEntity();

        // Entity 저장(데이터베이스 Insert)
        user1Repository.save(entity);
    }

    public User1DTO selectUser1(String uid){

        /*
            Optional
            - null 체크 검정을 손쉬고 안전하게 처리하기 위한 클래스
            - Spring JAP find~ 메서드의 결과 타입
        */
        Optional<User1> opt = user1Repository.findById(uid);
        
        // Entity 존재 여부 확인 후  Optional 타입으로 정의된 Entity 가죠오기
        if(opt.isPresent()){
            User1 user1 = opt.get(); 
            
            // Entity를 DTO로 변환해서 반환
            return user1.toDTO();
        }
        return null;
    }

    public List<User1DTO> selectUser1s(){

        // Entity 전체 조회
        List<User1> user1s = user1Repository.findAll();

        // for(외부 반복자)를 이용한 Entity리스트를 DOT 리스토로 변환
        /*
        List<User1DTO> user1DTOS = new ArrayList<>();
        for(User1 user1 : user1s){

            user1DTOS.add(user1.toDTO());
        }*/

        // stream(내부반복자를 이용한) Entity리스트를 DOT 리스토로 변환
        List<User1DTO> users = user1s
                                .stream()
                                .map(entity -> entity.toDTO())
                                .collect(Collectors.toList());


        return users;
    }

    public void updateUser1(User1DTO user1DTO) {

        // Entity 존재여부 확인
        boolean result = user1Repository.existsById(user1DTO.getUid());

        if(result){
            // DTO를 Entity로 변환
            User1 entity = user1DTO.toEntity();

            // Entity 수정(데이터베이스 Update)
            user1Repository.save(user1DTO.toEntity());
            
        }
    }

    public void deleteUser1(String uid) {
        // Entity 삭제(데이터베이스 Delete)
        user1Repository.deleteById(uid);
    }

    

}
