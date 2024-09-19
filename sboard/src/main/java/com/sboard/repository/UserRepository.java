package com.sboard.repository;

import com.sboard.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    boolean existsByUid(String uid);
    boolean existsByNick(String nick);
    boolean existsByEmail(String email);
    boolean existsByHp(String hp);

}
