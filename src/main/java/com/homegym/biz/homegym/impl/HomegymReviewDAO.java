package com.homegym.biz.homegym.impl;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.homegym.biz.homegym.Criteria;
import com.homegym.biz.homegym.HomegymReviewVO;

import lombok.extern.log4j.Log4j;

@Repository
@Log4j
public class HomegymReviewDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	// 리뷰 등록 
	public int insert(HomegymReviewVO vo) {
		
		return mybatis.insert("HomegymReviewDAO.insert", vo);
	}
	
	// 리뷰 조회
	public HomegymReviewVO read(int reviewId) {
		
		return mybatis.selectOne("HomegymReviewDAO.read", reviewId);
	}
	
	// 리뷰 삭제
	public int delete(int reviewId) {
		
		return mybatis.delete("HomegymReviewDAO.delete", reviewId);
	}
	
	// 리뷰 수정
	public int update(HomegymReviewVO vo) {
		
		return mybatis.update("HomegymReviewDAO.update", vo);
	}
	
	// 게시물에 등록된 리뷰 전체 리스트 조회 
	public List<HomegymReviewVO> getList(Criteria cri, int hId){
		
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("cri", cri);
		params.put("hId", hId);
		
		return mybatis.selectList("HomegymReviewDAO.getList", params);
	}
	
	// 게시물에 등록된 리뷰 전체 리스트 조회 
	public List<HomegymReviewVO> getListWithPaging(Criteria cri, int hId){
		
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("cri", cri);
		params.put("hId", hId);
		
		return mybatis.selectList("HomegymReviewDAO.getListWithPaging", params);
	}
	
	public int getCount(int hId) {
		
		return mybatis.selectOne("HomegymReviewDAO.getCount", hId);
	}
	
	/* 대여자가 쓴 리뷰가 이미 존재하는가 확인하는 쿼리*/
	public boolean exist(HomegymReviewVO vo) {
		
		return mybatis.selectOne("HomegymReviewDAO.exist", vo);
	}

	/* 게시글이 삭제될 때 해당 게시글 번호와 같은 리뷰들 모두 삭제하는 쿼리*/
	public void deleteAll(int hId) {
		
		mybatis.delete("HomegymReviewDAO.deleteAll", hId);
	}
}
