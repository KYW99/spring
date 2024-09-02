package com.ch02.config;

import com.ch02.sub1.greeting;
import com.ch02.sub1.hello;
import com.ch02.sub1.welcome;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.ch02"})
public class AppConfig {

    @Bean
    public hello hello(){
        return new hello();
    }

    @Bean(name = "welcome")
    public welcome welcome(){
        return new welcome();
    }

    @Bean("greet")
    public greeting greeting(){
        return new greeting();
    }

}
