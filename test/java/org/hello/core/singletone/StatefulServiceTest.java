package org.hello.core.singletone;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //ThreadA : 10000원 주문
        int userAPrice = statefulService1.order("userA", 10000);
        //ThreadB : 20000월 주문
        int userBPrice = statefulService2.order("userB", 20000);


        //ThreadA : 사용자 A 주문 금액 조회
//        int price = statefulService1.getPrice();
        System.out.println("price: " + userAPrice);
    }

    @Configuration
    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }


    }
}