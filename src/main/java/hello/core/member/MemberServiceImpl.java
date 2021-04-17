package hello.core.member;

// OCP 꺠짐 멤버서비스 의존.
public class MemberServiceImpl implements MemberService {

    //OCP가 깨짐 MemberMemoryRepository 여기에 의존하고
    private final MemberRepository memberRepository = new MemberMemoryRepository();

    @Override
    public void join(Member member) {

        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
