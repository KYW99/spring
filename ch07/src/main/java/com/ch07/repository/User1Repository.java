package com.ch07.repository;

import com.ch07.entity.User1;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

// JpaRepository<User1 , String> : 사용하는 엔티티 타입과 해당 엔티티의 @ID 컬럼 속성 타입 선언
@Repository
public interface User1Repository extends JpaRepository<User1 , String> {
    
    // 사용자 정의 쿼리 메서드
    public User1 findUser1ByUid(String Uid);

    public List<User1> findUser1ByName(String name);

    public List<User1> findUser1ByNameNot(String name);

    public User1 findUser1ByUidAndName(String Uid, String name);
    public User1 findUser1ByUidAndNameNot(String Uid, String name);

    public User1 findUser1ByAgeGreaterThan(int age);
    public User1 findUser1ByAgeGreaterThanEqual(int age);
    public User1 findUser1ByAgeLessThan(int age);
    public User1 findUser1ByAgeLessThanEqual(int age);
    public User1 findUser1ByAgeBetween(int low, int high);

    public List<User1> findUser1ByNameLike(String name);
    public List<User1> findUser1ByNameContains(String name);
    public List<User1> findUser1ByNameStartsWith(String name);
    public List<User1> findUser1ByNameEndsWith(String name);

    public List<User1> findUser1ByOrderByName();
    public List<User1> findUser1ByOrderByAgeAsc();
    public List<User1> findUser1ByOrderByAgeDesc();
    public List<User1> findUser1ByAgeGreaterThanOrderByAgeAsc(int age);

    public int countUser1ByUid(String Uid);
    public int countUser1ByName(String name);

    // JPQL : JPA Native SQL
    @Query("select u1 from User1 as u1 where u1.age < 30")
    public List<User1> selectUser1UnderAge30();

    @Query("select u1 from User1 as u1 where u1.name = ?1")
    public List<User1> selectUser1WhereName(String name);

    @Query("select u1 from User1 as u1 where u1.name = :name")
    public List<User1> selectUser1WhereNameParam(@Param("name") String name);

    @Query("select p from Parent as p " +
            "join Child as c on p.pid = c.parent " +
            "where p.pid = :pid")
    public List<Object[]> selectFromParentJoinChild(@Param("pid") String pid);



}
