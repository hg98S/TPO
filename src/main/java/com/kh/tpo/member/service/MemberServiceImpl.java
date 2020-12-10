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
		return mStore.insertMember(member);
	}

	@Override
	public int idDuplicateChk(String userId) {
		return mStore.idDuplicateChk(userId);
	}

	@Override
	public int modifyMember(Member member) {
		return mStore.updateMember(member);
	}

	@Override
	public int deleteMember(Member member) {
		return mStore.deleteMember(member);
	}

	@Override
	public ReservationInfo reservationInfo(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member findId(Member member) {
		return mStore.searchId(member);
	}

	@Override
	public Member findPwd(Member member) {
		return mStore.searchPwd(member);
	}

	@Override
	public int emailChk(Member member) {
		return mStore.emailChk(member);
	}

	@Override
	public int pwdDuplicateChk(Member member) {
		return mStore.pwdDuplicateChk(member);
	}

	
}
