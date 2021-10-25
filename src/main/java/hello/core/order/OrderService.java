package hello.core.order;

import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemoryMemberRepository;

public interface OrderService {

    Order createOrder(Long memberId, String itemName, int itemPrice);
}
