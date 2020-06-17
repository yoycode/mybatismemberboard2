package com.spring.mybatismb2.member;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mapper.MemberMapper;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	private SqlSession sqlSession;// Mybatis(ibatis) 라이브러리가 제공하는 클래스

	@Override
	public int insertMember(MemberVO memberVO) {
		// sqlSession 객체를 이용하여 memberMapper 객체 생성(필드로 생성)
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		//삽입후 삽입한 결과 상태 반환하기 위해 반환값을 int로 정해줌
		int res = memberMapper.insertMember(memberVO); 
		System.out.println("res=" + res);
		return res;
	}

	@Override
	public int userCheck(MemberVO memberVO) {
		// sqlSession 객체를 이용하여 memberMapper 객체 생성(필드로 생성)
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		int res = memberMapper.userCheck(memberVO); 
		
		return res;
	}

	@Override
	public ArrayList<MemberVO> getMemberlist() {
		// sqlSession 객체를 이용하여 memberMapper 객체 생성(필드로 생성)
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		ArrayList<MemberVO> member_list = new ArrayList<MemberVO>();
		member_list = memberMapper.getMemberlist();
	
		return member_list;
	}

	@Override
	public MemberVO selectMember(MemberVO memberVO) {
		// sqlSession 객체를 이용하여 memberMapper 객체 생성(필드로 생성)
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		MemberVO vo  = memberMapper.selectMember(memberVO);
			
		return vo;
	}

	@Override
	public int deleteMember(MemberVO memberVO) {
		// sqlSession 객체를 이용하여 memberMapper 객체 생성(필드로 생성)
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		int res = memberMapper.deleteMember(memberVO); 
		
		return res;
	}
}
