package org.hello.core.discount;

import org.hello.core.member.Member;

public interface DiscountPolicy {

    /**
     *
     * @return 할인 대상 금액
     */

    int discount(Member member, int price);
}
