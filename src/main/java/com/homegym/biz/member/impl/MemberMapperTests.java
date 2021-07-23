package com.homegym.biz.member.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.homegym.biz.member.MemberVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Log4j
public class MemberMapperTests {
	
	@Setter (onMethod_ = @Autowired)
	private MemberDAO memberDAO;
	
//	@Test
//	public void testRead() {
//		MemberVO vo = memberDAO.read("admin90");
//		log.info(vo);
//		
//		vo.getAuthList().forEach(authVO -> log.info(authVO));
//	}
	
	// 회원 가입 테스트 메서드
	@Test
	public void memberJoin() throws Exception {
		MemberVO vo = new MemberVO();
		
//		vo.setMId(0);
		vo.setMemberId("test");
		vo.setPassword("test");
		vo.setName("test");
//		vo.setNickname("test");
		vo.setPhone("test");
		vo.setZipCode("test");
		vo.setAddress("test");
//		vo.setImage(null);
		vo.setBirth("test");
		vo.setGender("1");
//		vo.setEnabled(null);
		
		memberDAO.memberJoin(vo);
	}
}
