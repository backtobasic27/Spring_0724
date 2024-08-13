package org.hello.core.order;

import org.hello.core.member.MemberRepository;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);

    MemberRepository getMemberRepository();

}
