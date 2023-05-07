package edu.kh.comm.common.interceptor;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import edu.kh.comm.board.model.service.BoardService;
import edu.kh.comm.board.model.vo.BoardType;

public class BoardTypeInterceptor implements HandlerInterceptor {
	
	private Logger logger = LoggerFactory.getLogger(BoardTypeInterceptor.class);
	
	@Autowired
	private BoardService boardService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// ServletContext == application scope 세팅 메서드 <-- application 전용임 ServletContext는
		// page, request, session scope는 setAttribute 사용
		// reuqest.getServletContext()는 request scope가 아니고
		// 그냥 클라이언트의 요청이야. 그니까 아래 코드를 직역하자면
		// 클라이언트의 요청 값을 application scope에 저장하겠다는 말이야
		ServletContext application = request.getServletContext();
		
		if(application.getAttribute("boardTypeList") == null) {
			List<BoardType> boardTypeList = boardService.selectBoardType();
			application.setAttribute("boardTypeList", boardTypeList);
		}
		
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
	
	
	
 
}
