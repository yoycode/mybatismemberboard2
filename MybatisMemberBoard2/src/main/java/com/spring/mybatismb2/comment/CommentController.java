package com.spring.mybatismb2.comment;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mybatismb2.board.CommentVO;

@RestController
/* 일반 컨트롤러는 view를 반환하지만 restController는 data만 반환해줌 */
public class CommentController {
	
	@Autowired
	CommentService mCommentService;
	
	// 댓글 리스트
	@RequestMapping(value="/comment_list.bo", produces="application/json;charset=utf-8") 
	private List<CommentVO> mCommentServiceList(@RequestParam int bno) throws Exception{
		/* 원래는 @RequestParam(value="bno") int bno 이렇게 썼는데 값이 같을 경우에는 value 생략 가능 */
		List<CommentVO> comment_list = mCommentService.commentListService(bno);
		
		return comment_list;
	}
	
	// 댓글 작성
	@RequestMapping(value="/comment_insert.bo", produces="application/json;charset=utf-8")
	private int mCommentServiceInsert(CommentVO comment, HttpSession session) throws Exception{
		/* commnet안에는 content와  hidden으로 받아온 bno가 저장됨 */
		comment.setWriter((String)session.getAttribute("id"));
		
		return mCommentService.commentInsertService(comment);
	}
	
	// 댓글 수정
	@RequestMapping(value="/comment_update.bo", produces="application/json;chasrset=utf-8")
	private int mCommentServiceUpdateProc(@RequestParam int cno, @RequestParam String content) throws Exception{
		CommentVO comment = new CommentVO();
		comment.setCno(cno);
		comment.setContent(content);
		
		return mCommentService.commentUpdateService(comment);
	}
	
	// 댓글 삭제 
	@RequestMapping(value="/comment_delete.bo", produces="application/json;charset=utf-8")
	private int mCommentServiceDelete(@RequestParam(value="cno") int cno) throws Exception{
		return mCommentService.commentDeleteService(cno);
	}

}
