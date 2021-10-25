package hello.core;

import hello.core.member.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "Woongstar", Grade.VIP);
        memberService.join(member);

        Member member1 = memberService.findMember(1L);
        System.out.println("member1 = " + member1.getName());
        System.out.println("member = " + member.getName());
    }
}
