package co.company.spring;

import co.company.spring.controller.MemberVO;

public class LombokTest {

	public static void main(String[] args) {
		MemberVO member2 = new MemberVO();
		MemberVO member = MemberVO.builder().id("몽데").name("이름").build();
		System.out.println(member);

	}

}
