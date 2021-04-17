package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RateDiscountPolicyTest {
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    // 한글 나오게 해줌
    @DisplayName("VIP 10% 할인 적용")
    void vip_o() {
        //given
        Member member = new Member(1L, "memberVIP", Grade.VIP);
        //when
        int disCount = discountPolicy.discount(member, 100000);
        //then
        assertThat(disCount).isEqualTo(10000);
    }

    @Test
    // 한글 나오게 해줌
    @DisplayName("VIP 아닐경우 할인 적용 안됨")
    void vip_x(){
        //given
        Member member = new Member(1L, "memberBACIS", Grade.Basic);
        //when
        int disCount = discountPolicy.discount(member, 100000);
        //then
        assertThat(disCount).isEqualTo(0);
    }

}