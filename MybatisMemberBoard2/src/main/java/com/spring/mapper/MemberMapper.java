package com.spring.mapper;
// mapper.xml과 동일한 패키지에 소스파일 생성할것  

import java.util.ArrayList;

import com.spring.mybatismb2.member.MemberVO;

public interface MemberMapper {
	public ArrayList<MemberVO> getMemberlist();
	public int insertMember(MemberVO memberVO);
	public MemberVO selectMember(MemberVO memberVO);
	public int userCheck(MemberVO memberVO);
	public int deleteMember(MemberVO memberVO);
}