package org.hello.core.order;

import org.assertj.core.api.Assertions;
import org.hello.core.discount.FixDiscountPolicy;
import org.hello.core.member.Grade;
import org.hello.core.member.Member;
import org.hello.core.member.MemberRepository;
import org.hello.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    @Test
    void createOrder() {
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member("name",1L, Grade.VIP));

        OrderService orderService = new OrderServiceImpl(memberRepository, new FixDiscountPolicy());
        Order order = orderService.createOrder(1l,"itemB",10000) ;
        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}