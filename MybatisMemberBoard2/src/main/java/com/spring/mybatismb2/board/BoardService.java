package com.spring.mybatismb2.board;

import java.util.HashMap;
import java.util.List;

public interface BoardService {
	public int getListCount();
	public List<BoardVO> getBoardList(HashMap<String, Integer> hashmap);
	public BoardVO getDetail(int num);
	public int boardInsert(BoardVO board);
	public int boardReply(BoardVO board);
	public BoardVO boardModifyForm(int num);
	public int boardModify(BoardVO modifyboard);
	public int boardDelete(HashMap<String, String> hashmap);
}
