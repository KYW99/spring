package com.ch07.repository;

import com.ch07.entity.Child;
import com.ch07.entity.Parent;
import com.ch07.entity.User1;
import org.apache.ibatis.annotations.Param;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Query;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class User1RepositoryTest {

    private static final Logger log = LoggerFactory.getLogger(User1RepositoryTest.class);
    @Autowired
    private User1Repository user1Repository;


    @Test
    void findUser1ByUid() {
        User1 entity = user1Repository.findUser1ByUid("a101");

        System.out.println(entity);
    }

    @Test
    void findUser1ByName() {
        List<User1> users = user1Repository.findUser1ByName("감감감감");
        System.out.println(users);
    }

    @Test
    void findUser1ByNameNot() {
        List<User1> users = user1Repository.findUser1ByNameNot("감감감감");
        System.out.println(users);
    }

    @Test
    void findUser1ByUidAndName() {
        User1 entity = user1Repository.findUser1ByUidAndName("a101", "감감감감");
        System.out.println(entity);
    }

    @Test
    void findUser1ByUidAndNameNot() {
        User1 entity = user1Repository.findUser1ByUidAndNameNot("a101","감감감감");
        System.out.println(entity);

    }

    @Test
    void findUser1ByAgeGreaterThan() {
        User1 entity = user1Repository.findUser1ByAgeGreaterThan(27);
        System.out.println(entity);

    }

    @Test
    void findUser1ByAgeGreaterThanEqual() {
        User1 entity = user1Repository.findUser1ByAgeGreaterThanEqual(27);
        System.out.println(entity);
    }

    @Test
    void findUser1ByAgeLessThan() {
        User1 entity = user1Repository.findUser1ByAgeLessThan(27);
        System.out.println(entity);
    }

    @Test
    void findUser1ByAgeLessThanEqual() {
        User1 entity = user1Repository.findUser1ByAgeLessThanEqual(27);
        System.out.println(entity);

    }

    @Test
    void findUser1ByAgeBetween() {
        User1 entity = user1Repository.findUser1ByAgeBetween(27, 90);
        System.out.println(entity);
    }

    @Test
    void findUser1ByNameLike() {
        List<User1> users = user1Repository.findUser1ByNameLike("감감");
        System.out.println(users);
    }

    @Test
    void findUser1ByNameContains() {
        List<User1> users = user1Repository.findUser1ByNameContains("감");
        System.out.println(users);
    }

    @Test
    void findUser1ByNameStartsWith() {
        List<User1> users = user1Repository.findUser1ByNameStartsWith("감");
        System.out.println(users);
    }

    @Test
    void findUser1ByNameEndsWith() {
        List<User1> users = user1Repository.findUser1ByNameEndsWith("감");
        System.out.println(users);
    }

    @Test
    void findUser1ByOrderByName() {
        List<User1> users = user1Repository.findUser1ByOrderByName();
        System.out.println(users);
    }

    @Test
    void findUser1ByOrderByAgeAsc() {
        List<User1> users = user1Repository.findUser1ByOrderByAgeAsc();
        System.out.println(users);
    }

    @Test
    void findUser1ByOrderByAgeDesc() {
        List<User1> users = user1Repository.findUser1ByOrderByAgeDesc();
        System.out.println(users);
    }

    @Test
    void findUser1ByAgeGreaterThanOrderByAgeAsc() {
        List<User1> users = user1Repository.findUser1ByAgeGreaterThanOrderByAgeAsc(20);
        System.out.println(users);
    }

    @Test
    void countUser1ByUid() {
        long count = user1Repository.countUser1ByUid("a101");
        System.out.println(count);
    }

    @Test
    void countUser1ByName() {
        long count = user1Repository.countUser1ByName("감감감감");
        System.out.println(count);
    }

    @Test
    void selectUser1UnderAge30(){}

    @Test
    void selectUser1WhereName(String name){}

    @Test
    void selectUser1WhereNameParam(@Param("name") String name){}

    @Test
    void selectFromParentJoinChild(){
        List<Object[]> list = user1Repository.selectFromParentJoinChild("p101");

        System.out.println(list.size());

        for(Object[] obj : list){
            System.out.println(Arrays.toString(obj));

            Parent parent = (Parent) obj[0];
            Child child = (Child) obj[1];

            System.out.println(parent);
            System.out.println(child);
        }

    }
}