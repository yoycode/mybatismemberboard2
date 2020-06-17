package com.spring.mybatismb2.comment;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mapper.CommentMapper;
import com.spring.mybatismb2.board.CommentVO;

@Service("mCommentService")
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int commentCount() throws Exception {
		CommentMapper mCommentMapper = sqlSession.getMapper(CommentMapper.class);
		
		return mCommentMapper.commentCount();
	}

	@Override
	public List<CommentVO> commentListService(int bno) throws Exception {
		CommentMapper mCommentMapper = sqlSession.getMapper(CommentMapper.class);
		return mCommentMapper.commentList(bno);
	}

	@Override
	public int commentInsertService(CommentVO comment) throws Exception {
		CommentMapper mCommentMapper = sqlSession.getMapper(CommentMapper.class);
		return mCommentMapper.commentInsert(comment);
	}

	@Override
	public int commentUpdateService(CommentVO comment) throws Exception {
		CommentMapper mCommentMapper = sqlSession.getMapper(CommentMapper.class);
		return mCommentMapper.commentUpdate(comment);
	}

	@Override
	public int commentDeleteService(int cno) throws Exception {
		CommentMapper mCommentMapper = sqlSession.getMapper(CommentMapper.class);
		return mCommentMapper.commentDelete(cno);
	}

}
