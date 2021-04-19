package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService {
    
    // 멤버를 가져와야 되기 때문에 멤버 리파시토리 생성
    //private final MemberRepository memberRepository = new MemberMemoryRepository();
    private final MemberRepository memberRepository;

    /** 주문시 할인율 적용하기 위해 DiscountPolicy 생성
     * 고정 할인 금액에서 비율산정으로 변경
     * 문제점 발생
     * 소스코드 수정이 들어감.
     * 구현체를 없애야 한다.
     * 구현체를 없애고 누군가 DI를 해줘야 한다.
     */
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    private final DiscountPolicy discountPolicy;


    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
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
}
