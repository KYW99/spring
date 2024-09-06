package com.ch06.service;

import com.ch06.dto.User2DTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class User2ServiceTest {

    @Autowired
    private User2Service user2Service;

    @Test
    void insertUser2() {

        //given
        User2DTO sample = User2DTO.builder()
                .uid("a201")
                .name("김유신")
                .birth("1999-01-02")
                .addr("부산진구")
                .build();

        //when
        user2Service.insertUser2(sample);

        //then
        User2DTO expected = user2Service.selectUser2(sample.getUid());
        Assertions.assertEquals(expected.toString(), sample.toString());
    }

    @Test
    void selectUser2() {

        //given
        String uid = "a201";

        //when
        User2DTO expected = user2Service.selectUser2(uid);

        //then
        Assertions.assertEquals(expected.getUid(), uid);
    }

    @Test
    void selectUser2s() {
        List<User2DTO> expected = user2Service.selectUser2s();

        Assertions.assertFalse(expected.isEmpty());
    }

    @Test
    void updateUser2() {

        // given
        User2DTO sample = User2DTO.builder()
                .uid("a201")
                .name("김유신")
                .birth("1999-01-02")
                .addr("부산진구")
                .build();

        // when
        user2Service.updateUser2(sample);

        // then
        User2DTO expected = user2Service.selectUser2(sample.getUid());
        Assertions.assertEquals(expected.toString(), sample.toString());
    }

    @Test
    void deleteUser2() {

        String uid = "a201";
        user2Service.deleteUser2(uid);
        User2DTO expected = user2Service.selectUser2(uid);
        Assertions.assertNull(expected);
    }
}