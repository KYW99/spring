package com.ch04.service;

import com.ch04.dao.User2DAO;
import com.ch04.dto.User2DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class User2Service {

    private User2DAO dao;


    @Autowired
    public User2Service(User2DAO dao) {
        this.dao = dao;
    }
    public void insertUser2(User2DTO dto){
        dao.insertUser2(dto);
    }
    public User2DTO selectUser2(){
        return dao.selectUser2();
    }
    public List<User2DTO> selectUser2s(){
        return dao.selectUser2s();
    }
    public void updateUser2(){
        dao.updateUser2();
    }
    public void deleteUser2(){
        dao.deleteUser2();
    }
}
