package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemoryMemberRepository;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 어플리케이션 설정을 하고 구성
// @Configuration 설정정보에 해당 태그 적용
@Configuration
public class AppConfig {

    //호출 순서는 보장 하지 않지만 논리적으로 봤을때 다음과 같은 결과를 기대한다.
    //1. System.out.println("Call: AppConfig.memberService");
    //2. System.out.println("Call: AppConfig.memberRepository");
    //3. System.out.println("Call: AppConfig.memberRepository");
    //4. System.out.println("Call: AppConfig.orderService");
    //5. System.out.println("Call: AppConfig.memberRepository");
    // 하지만 실제로 다음과 같이 출력된다.
    //

    // 여기서 DI를 해줌
    // DI를 해줌으로써 역할과 구현이 분리됨.

    //@Bean 입력시 스프링 컨테이너에 등록됨.
    //등록시 이름이 등록되는데 해당 이름은 메소드 이름이다. memberService
    // Key: memberService, value 객체
    @Bean
    public MemberService memberService() {
        System.out.println("Call: AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    // memory에서 다른 DB로 변경될 경우 해당 코드만 변경하면 됨.
    @Bean
    public MemberRepository memberRepository() {
        System.out.println("Call: AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("Call: AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        // FixDiscountPolicy -> RateDiscountPolicy로 변경.
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
