package com.spring.mapper;

import java.util.HashMap;
import java.util.List;

import com.spring.mybatismb2.board.BoardVO;

public interface BoardMapper {
	public int getListCount();
	public List<BoardVO> getBoardList(HashMap<String, Integer> hashmap);
	public BoardVO getDetail(int num);
	public int boardInsert(BoardVO board); //원글 insert작업 수행
	public int boardReplyupdate(BoardVO board); //답글에 대한 re_seq update작업 수행
	public int boardReply(BoardVO board); //답글 insert작업 수행
	public int boardModify(BoardVO modifyboard);
	public int boardDelete(int num);
	public void setReadCountUpdate(int num);
	public int isBoardWriter(HashMap<String, String> hashmap);
}
