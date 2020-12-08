package com.kh.tpo.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.tpo.member.domain.Member;
import com.kh.tpo.member.domain.ReservationInfo;
import com.kh.tpo.member.store.MemberStore;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberStore mStore;
	
	@Override
	public Member memberLogin(Member member) {
		return mStore.selectOne(member);
	}

	@Override
	public int registerMember(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int idDuplicateChk(String userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyMember(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ReservationInfo reservationInfo(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findId(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findPwd(String userPwd) {
		// TODO Auto-generated method stub
		return 0;
	}

}
