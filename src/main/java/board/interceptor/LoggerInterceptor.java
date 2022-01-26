package board.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoggerInterceptor implements HandlerInterceptor{ // HandlerInterceptorAdapter 는이제 없어져서 implements HandlerInterceptor 로 대체

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{ //컨트롤러 실행 전 수행
		log.debug("===============START=============");
		log.debug("Request URI \t: "+request.getRequestURI());
		return true;
	}
	
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,ModelAndView modelAndView) throws Exception { //컨트롤러 실행된 후 실행
		log.debug("==================== END ====================");
	}
}
