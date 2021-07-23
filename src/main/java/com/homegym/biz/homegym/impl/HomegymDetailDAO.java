package com.homegym.biz.homegym.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.homegym.biz.homegym.HomegymDetailVO;
import com.homegym.biz.homegym.HomegymVO;

import lombok.extern.log4j.Log4j;

@Repository
@Log4j
public class HomegymDetailDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	// 글 작성 
	public void insert(HomegymDetailVO vo) {
		
		mybatis.insert("HomegymDetailDAO.insert", vo);
	}
	
	// 주소 가져오기
	public HomegymVO select(int hId) {
		
		return mybatis.selectOne("HomegymDetailDAO.selectAddr", hId);
	}
	
	// 예약된 내역 리스트
	public List<HomegymDetailVO> selectReservationList(int hId) {
		
		return mybatis.selectList("HomegymDetailDAO.selectReservationList", hId);
	}
}
