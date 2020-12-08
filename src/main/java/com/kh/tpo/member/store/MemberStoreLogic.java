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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int idDuplicateChk(String userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateMember(Member member) {
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
	public String searchId(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int searchPwd(String userPwd) {
		// TODO Auto-generated method stub
		return 0;
	}

}
