package com.page.yoon.service;

import com.page.yoon.entity.Member;
import com.page.yoon.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true) // spring, javax 두가지 있음. spring 권장
@RequiredArgsConstructor
public class MemberService {

    /**
     * MemberRepository 주입 방법
     *
     * 1. 필드 주입은 까다로움 변경시..?
        @Autowired
        private MemberRepository memberRepository;
     * 2. 런타임 중 바꿀일 없으므로 setter 비권장
        @Autowired
        public void setMemberRepository(MemberRepository memberRepository) {
            this.memberRepository = memberRepository;
        }
     * 3. 생성자 권장
        @Autowired
        public MemberService(MemberRepository memberRepository) {
            this.memberRepository = memberRepository
        }
        -> @AllArgsConstructor 사용시 spring 이 알아서 해줌..
            @RequiredArgsConstructor 는 final 만 (final 권장함)
     */
    private final MemberRepository memberRepository;


    /**
     * 회원 가입
     */
    @Transactional
    public Integer join(Member member) {
        // 중복 회원 검증
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        // Exception
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("존재하는 회원");
        }
    }

    /**
     * 회원 전체 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    /**
     * 회원 단건 조회
     */
    public Member findOne(Integer memberId) {
        return memberRepository.findOne(memberId);
    }
}
