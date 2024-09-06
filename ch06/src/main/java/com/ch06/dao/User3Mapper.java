package com.ch06.dao;

import com.ch06.dto.User3DTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface User3Mapper {

    public void insertUser3(User3DTO dto);
    public List<User3DTO> selectUser3s();
    public User3DTO selectUser3(String uid);
    public void updateUser3(User3DTO user3DTO);
    public void deleteUser3(String uid);
}
