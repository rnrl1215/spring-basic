package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {
    
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;


    @Autowired
    private DiscountPolicy rateDiscountPolicy;


    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy rateDiscountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = rateDiscountPolicy;
    }

    @Override
    public Order createOrder(Long memberID, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberID);

        // 잘된 설계 나는 어떻게 되는지 모르겠고 일단 값만 던질테니까 알아서 가져와줘
        // 내용을 몰라도 된다. 할인이 변경되면 할인 쪽만 바꾸면 된다.
        // 여기서는 할인이 변경되어도 고칠게 없다.
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberID, itemName, itemPrice, discountPrice);
    }

    // Test 전용
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
