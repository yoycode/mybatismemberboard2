package com.spring.mybatismb2.board;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mapper.BoardMapper;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int getListCount() {
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		int res = boardMapper.getListCount();
		return res;
	}

	@Override
	public List<BoardVO> getBoardList(HashMap<String, Integer> hashmap) {
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		
		List<BoardVO> boardlist = boardMapper.getBoardList(hashmap);
		return boardlist;
	}

	@Override
	public BoardVO getDetail(int num) {
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		boardMapper.setReadCountUpdate(num);
		BoardVO board = boardMapper.getDetail(num);
		return board;
	}

	@Override
	public int boardInsert(BoardVO board) {
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		int res = boardMapper.boardInsert(board);
		
		return res;
	}

	@Override
	public int boardReply(BoardVO board) {
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		boardMapper.boardReplyupdate(board);
		board.setRe_seq(board.getRe_seq()+1);
		board.setRe_lev(board.getRe_lev()+1);
		int res = boardMapper.boardReply(board);

		return res;
	}
	
	@Override
	public BoardVO boardModifyForm(int num) {
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		BoardVO board = boardMapper.getDetail(num);
		return board;
	}
	
	@Override
	public int boardModify(BoardVO modifyboard) {
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		int res =  boardMapper.boardModify(modifyboard);
		return res;
	}

	@Override
	public int boardDelete(HashMap<String, String> hashmap) {
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		int res =  boardMapper.isBoardWriter(hashmap);
		int num = Integer.parseInt(hashmap.get("num"));
		if (res == 1) {
			res =  boardMapper.boardDelete(num);
		}
		return res;
	}
}
