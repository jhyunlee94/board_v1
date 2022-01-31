package board.common;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice //해당 클래스가 예외처리 클래스임을 알린다.
@Slf4j
public class ExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)// 해당 메소드에서 처리할 예외를 지정 , Exception.class로 모든 예외를 처리
	public ModelAndView defaultExceptionHandler(HttpServletRequest request, Exception exception) {
		ModelAndView mv = new ModelAndView("/board/error_default");
		mv.addObject("exception",exception);
		
		log.error("exception",exception);
		return mv;
	}
}
