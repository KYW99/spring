package com.ch10.jwt;

import com.ch10.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JwtProviderTest {

    @Autowired
    private JwtProvider jwtProvider;

    @Test
    void createToken() {

        User user = User.builder()
                .uid("a133")
                .name("김유신")
                .birth("1999-11-11")
                .role("ADMIN")
                .build();

        String jwt = jwtProvider.createToken(user, 1);
        System.out.println(jwt);
    }

    @Test
    void getClaims() {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJkbmpzcmxkdXMwMUBnbWFpbC5jb20iLCJpYXQiOjE3MjYxMjMxMzEsImV4cCI6MTcyNjIwOTUzMSwidXNlcm5hbWUiOiJhMTMzIiwicm9sZSI6IkFETUlOIn0.wHPq4x3eGk7LF5CiBKB7rIlX3RPb0G6Xp2r_oKFRalM\n";

        Claims claims = jwtProvider.getClaims(token);
        String username = (String) claims.get("username");
        String role = (String) claims.get("role");

        System.out.println(username + " " + role);


    }

    @Test
    void getAuthentication() {
    }

    @Test
    void validateToken() {

        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJkbmpzcmxkdXMwMUBnbWFpbC5jb20iLCJpYXQiOjE3MjYxMjMxMzEsImV4cCI6MTcyNjEyMzEzMSwidXNlcm5hbWUiOiJhMTMzIiwicm9sZSI6IkFETUlOIn0.Yt8h_4382zFYfNiPRJw1lhEm3nUNVEzZ6XEscY3D3Xs";

        try {
            jwtProvider.validateToken(token);
            System.out.println("토큰 이상 없음");
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}