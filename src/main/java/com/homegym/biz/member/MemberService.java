package com.homegym.biz.member;

import java.util.HashMap;
import java.util.List;

import java.util.Map;

import com.homegym.biz.homegym.HomegymDetailVO;
import com.homegym.biz.homegym.HomegymReviewVO;
import com.homegym.biz.homegym.HomegymVO;
import com.homegym.biz.trainerboard.TrainerBoardVO;
import com.homegym.security.CustomUserDetails;

public interface MemberService {

	//회원가입
    public void memberJoin(MemberVO member) throws Exception;
    
    //카카오 회원가입
    public void memberJoinKakao(CustomUserDetails kakaoMember) throws Exception;
    
    //카카오 프로필 정보가져오기
  	public CustomUserDetails getUserKakao(String memberId);
    
    //아이디 중복 체크
  	public int idCheck(String memberId) throws Exception;
  	
    //닉네임 중복 체크
  	public int nickCheck(String nickName) throws Exception;

	//프로필 정보가져오기
	public CustomUserDetails getUser(String memberId);
	
	//회원정보 수정페이지 
	public CustomUserDetails getMyPageInfo(String memberId);
	
	//회원정보 수정
	public int memberUpdate(CustomUserDetails vo);
	
	//프로필 이미지 등록
	public void userImgUpload(HashMap<String, Object> paramMap);

	//프로필 이미지 삭제
	public int userImgDelete(String memberId);
	
	//회원 탈퇴 처리
	public int memberDelete(CustomUserDetails vo);
	
	//비밀번호 체크
	public boolean checkPw(String memberId, String password);

	//내가 쓴 게시글 리스트 조회
	public List<TrainerBoardVO> getMyBoardPaging(String memberId, Criteria cri);
	
	// 수락 대기중인 홈짐 수 조회
	public int getMyWaitngHomegymCnt(String memberId);
	
	//내가 올린 홈짐 수 조회
	public int getLendHomeGymCnt(String memberId);
	
	//내가 빌리려고 예약한 홈짐 수 조회
	public int getRentHomeGymCnt(String memberId);
	
	//거절된 홈짐수를 뺀 빌린 홈짐 수 조회
	public int getRealRentCnt(String memberId);
	
	//내가 쓴 글 수 조회
	public int getMyAllBoardCnt(String memberId);
	
	//내가 쓴 댓글 수 조회
	public int getMyAllReviewCnt(String memberId);
	
	//수락 대기중인 홈짐
	public List<Map<String, String>> getWaitingHGPaging(String memberId,Criteria cri);
	
	//내가 빌려준 홈짐 조회
	public List<Map<String, String>> getLendHGPaging(String memberId,Criteria cri);
	
	//내가 빌린 홈짐 조회
	public List<Map<String, String>> getRentdHGPaging(String memberId,Criteria cri);
	
	//진행중인 홈짐 조회
	public List<HomegymVO> getMyProgressHomegym(String memberId,Criteria cri);
	
	//완료된 홈짐 조회
//	public List<HomegymVO> getMyFinishedHomegym(String memberId);
	
	//내가 쓴 리뷰 조회
	public List<Map<String, String>> getMyReviewsPaging(String memberId,Criteria cri);
	
	// 결제 상태 변경 
	public void payUpdate(HomegymDetailVO vo);
	
	//홈짐 수락 상태 변경
	public int HomegymAcceptUpdate(Map<String, String> paramMap);
	
	//홈짐 거절 상태 변경
	public int HomegymRejectUpdate(Map<String,String> paramMap);
	//홈짐 예약 요청 조회
	public HomegymDetailVO getMyRequest(HomegymDetailVO vo,int dId);

	

}
