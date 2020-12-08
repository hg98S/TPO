package com.kh.tpo.member.store;

import com.kh.tpo.member.domain.Member;
import com.kh.tpo.member.domain.ReservationInfo;

public interface MemberStore {

	/*
	 * 	로그인
	 *  
	 *  @Param Member
	 *  @Return Member
	 * */
	public Member selectOne(Member member);
	/*
	 * 	회원가입
	 *  
	 *  @Param Member
	 *  @Return Member
	 * */
	public int insertMember(Member member);
	/*
	 *  아이디 중복검사
	 *  
	 *  @Param String 
	 *  @Return int
	 * */
	public int idDuplicateChk(String userId);
	/*
	 * 	회원정보 수정
	 *  
	 *  @Param Member
	 *  @Return int
	 * */
	public int updateMember(Member member);
	/*
	 * 	회원탈퇴
	 *  
	 *  @Param Member
	 *  @Return int
	 * */
	public int deleteMember(Member member);
	/*
	 * 	회원 항공 예약 정보
	 *  
	 *  @Param Member
	 *  @Return ReservationInfo
	 * */
	public ReservationInfo reservationInfo(String userId);
	/*
	 * 	회원 아이디 찾기
	 *  
	 *  @Param Member
	 *  @Return String
	 * */
	public String searchId(String userId);
	/*
	 * 	회원 비밀번호 찾기
	 *  
	 *  @Param Member
	 *  @Return int
	 * */
	public int searchPwd(String userPwd);
}
