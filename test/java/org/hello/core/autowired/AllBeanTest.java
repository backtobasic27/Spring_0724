package org.hello.core.autowired;

import org.hello.core.AutoAppConfig;
import org.hello.core.discount.DiscountPolicy;
import org.hello.core.member.Grade;
import org.hello.core.member.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class AllBeanTest {

    private static final Logger log = LoggerFactory.getLogger(AllBeanTest.class);

    @Test
    void findAllBean() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);

        DiscountService discountService = ac.getBean(DiscountService.class);
        Member member = new Member("userA", 1L, Grade.VIP);
        int discountPrice = discountService.discount(member, 10000, "fixDiscountPolicy");
        // FixDiscountPolicy 라고 쓰면 NullPointerException 오류가 뜨니 주의 하라. 그렇다면 왜 뜨는가?
        // policyMap 객체의 key 값, 즉 String...... 아 모르겠다 왜 discountCode 값에 소문자 f가 아닌, 대문자 f 를 넣으면 널포인트 익셉션이 뜨는 것이지?

        assertThat(discountService).isInstanceOf(DiscountService.class);
        assertThat(discountPrice).isEqualTo(1000);
    }

    static class DiscountService {
        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policies;

        @Autowired
        public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policies) {
            this.policyMap = policyMap;
            this.policies = policies;
            log.debug("policyMap = {}", policyMap);
            System.out.println("policyMap = " + policyMap);
//            System.out.println("policies = " + policies);
        }

        public int discount(Member member, int price, String discountCode) {
            DiscountPolicy discountPolicy = policyMap.get(discountCode);
            return discountPolicy.discount(member, price);
        }
    }
}
