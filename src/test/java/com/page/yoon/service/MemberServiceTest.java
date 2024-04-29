package com.page.yoon.service;

import com.page.yoon.entity.Base;
import com.page.yoon.entity.Member;
import com.page.yoon.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    public void 회원가입() throws Exception {
        // given
        Member member = new Member();
        member.setName("name");
        member.setPhone("01012341234");
        member.setPassword("password");

        Base base = new Base();
        base.setCreatedAt(LocalDateTime.now());
        member.setBase(base);

        // when
        Integer saveId = memberService.join(member);

        // then
        assertEquals(member, memberRepository.findOne(saveId));

    }

    @Test()
    public void 중복_회원_예외() throws Exception {
        // given
        Member member1 = new Member();
        member1.setName("name");
        member1.setPhone("01012341234");
        member1.setPassword("password");

        Member member2 = new Member();
        member2.setName("name");
        member2.setPhone("01012341234");
        member2.setPassword("password");

        Base base = new Base();
        base.setCreatedAt(LocalDateTime.now());
        member1.setBase(base);
        member2.setBase(base);

        // when
        memberService.join(member1);

        assertThrows(IllegalStateException.class, () -> {
            // 중복 에러로 예외 발생함
            memberService.join(member2);
        });

        // then

    }
}