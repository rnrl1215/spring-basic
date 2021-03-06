package hello.core.singletone;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
        //1. 조회
        MemberService memberService1 = appConfig.memberService();

        //2. 조회
        MemberService memberService2 = appConfig.memberService();

        //3. 참조값 테스트
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        //memberservice1 != memberservice2
        Assertions.assertThat(memberService1).isNotSameAs(memberService2);
    }
}
