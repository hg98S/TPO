package com.kh.tpo.member.store;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.tpo.member.domain.Member;
import com.kh.tpo.member.domain.ReservationInfo;

@Repository
public class MemberStoreLogic implements MemberStore{

	@Autowired
	private SqlSessionTemplate session;
	
	@Override
	public Member selectOne(Member member) {
		return session.selectOne("MemberMapper.selectOne", member);
	}

	@Override
	public int insertMember(Member member) {
		return session.insert("MemberMapper.insertMember", member);
	}

	@Override
	public int idDuplicateChk(String userId) {
		return session.selectOne("MemberMapper.checkIdDup",userId);
	}

	@Override
	public int updateMember(Member member) {
		return session.update("MemberMapper.updateMember", member);
	}

	@Override
	public int deleteMember(Member member) {
		return session.update("MemberMapper.deleteMember", member);
	}

	@Override
	public ReservationInfo reservationInfo(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member searchId(Member member) {
		return session.selectOne("MemberMapper.searchId",member);
	}

	@Override
	public Member searchPwd(Member member) {
		return session.selectOne("MemberMapper.searchPwd", member);
	}

	@Override
	public int emailChk(Member member) {
		return session.selectOne("MemberMapper.emailChk", member);
	}

	@Override
	public int pwdDuplicateChk(Member member) {
		return session.selectOne("MemberMapper.pwdDuplicateChk", member);
	}

}
