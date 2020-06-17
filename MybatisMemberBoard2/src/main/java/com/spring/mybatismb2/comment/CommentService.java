package com.spring.mybatismb2.comment;

import java.util.List;

import com.spring.mybatismb2.board.CommentVO;

public interface CommentService {
	public int commentCount() throws Exception; // 댓글 개수
	public List<CommentVO> commentListService(int bno) throws Exception; // 댓글 목록
	public int commentInsertService(CommentVO comment) throws Exception; // 댓글 작성
	public int commentUpdateService(CommentVO comment) throws Exception; // 댓글 수정
	public int commentDeleteService(int cno) throws Exception; // 댓글 삭제

}
