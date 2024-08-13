package org.hello.core.scan;

import org.hello.core.AutoAppConfig;
import org.hello.core.member.MemberRepository;
import org.hello.core.member.MemberService;
import org.hello.core.order.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoAppConfigTest {

    @Test
    void basicScan() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);

        OrderService bean = ac.getBean(OrderService.class);
        MemberRepository memberRepository = bean.getMemberRepository();
        System.out.println("memberRepository =" + memberRepository );
    }
}
