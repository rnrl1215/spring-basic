package hello.core.member;

// OCP 꺠짐 멤버서비스 의존.
public class MemberServiceImpl implements MemberService {

    //OCP가 깨짐 MemberMemoryRepository 여기에 의존하고
    // 주석처리 memberRepository 객체는 이제 생성자를 통해서
    // 주입받음.
    // private final MemberRepository memberRepository = new MemberMemoryRepository();
    private final MemberRepository memberRepository;

    public  MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {

        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // Test 전용
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
