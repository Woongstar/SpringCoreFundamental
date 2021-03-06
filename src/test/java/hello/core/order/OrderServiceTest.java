package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }


    @Test
    void createOrder(){
        long memberId = 1L;
        Member woongstarB = new Member(memberId, "woongstarB", Grade.VIP);
        memberService.join(woongstarB);

        Order order = orderService.createOrder(memberId,"macPro",20000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(2000);

    }
}
