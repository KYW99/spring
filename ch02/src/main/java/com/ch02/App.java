package com.ch02;

import com.ch02.config.AppConfig;
import com.ch02.sub1.greeting;
import com.ch02.sub1.hello;
import com.ch02.sub1.welcome;
import com.ch02.sub2.Computer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 날짜 : 2024/09/01
 * 이름 : 원기연
 * 내용 : 2장 Spring Ioc/DI 실습하기
 *
 * @configuration
 *  - 애플리케이션을 구성하는 빈을 등록하기 윈한 설정 클래스
 *  - XML, 설정파일 대신 Java 클래스를 사용해 스프링 컨테이너 설정
 *  
 * @Bean
 *  - 컨테이너에 등록하기 위한 빈 설정
 *  - 사용자 정의 클래스, 외부 라이브러리 빈 등록
 *  
 * @ComponentScan
 *  - basePackages로 시작하는 패키지내의 빈을 스캔해서 컨테이너에 등록
 *  - 스캔 대상 컴포넌트는 @Component 선언
 *  
 * @Component
 *  - 스캐닝으로 컨테이너에 등록할 대상 컴포넌트 설정
 *  - @Controller, @Service, @Repository로 파생
 *  
 * @Autowired
 *  - 컨테이너의 빈을 주입
 *  - 이름 또는 클래스 타입으로 매칭된 빈을 주입
 *
 *
 */
public class App 
{
    public static void main( String[] args ) {

        // 스프링 컨테이너 생성
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // 빈 가져오기
        hello hello = context.getBean(hello.class);
        hello.show();

        welcome welcome = (welcome) context.getBean("welcome");
        welcome.show();

        greeting greeting = (greeting) context.getBean("greet");
        greeting.show();

        // IoC/DI 실습
        Computer com = (Computer) context.getBean("com");
        com.show();

    }
}
