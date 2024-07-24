package org.hello.core.order;

import org.hello.core.AppConfig;
import org.hello.core.member.Grade;
import org.hello.core.member.Member;
import org.hello.core.member.MemberService;
import org.hello.core.member.MemberServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member("memberA", memberId, Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = " + order);
        //System.out.println("order.calculatePrice =" + order.calculatePrice());
    }
}
