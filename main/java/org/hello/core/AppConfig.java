package org.hello.core;

import org.hello.core.discount.DiscountPolicy;
import org.hello.core.discount.FixDiscountPolicy;
import org.hello.core.discount.RateDiscountPolicy;
import org.hello.core.member.MemberService;
import org.hello.core.member.MemberServiceImpl;
import org.hello.core.member.MemoryMemberRepository;
import org.hello.core.order.OrderService;
import org.hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
       // return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
