package com.bookshop.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.bookshop.annotation.LoginRequired;
import com.bookshop.dto.Result;
import com.bookshop.enums.ControllerType;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO 自动生成的方法存根

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO 自动生成的方法存根

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if (!(handler instanceof HandlerMethod)) {
            return true;
        }
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		LoginRequired methodAnnotation = handlerMethod.getMethodAnnotation(LoginRequired.class);
		LoginRequired classAnnotation = handlerMethod.getBean().getClass().getAnnotation(LoginRequired.class);
		
		if(methodAnnotation == null && classAnnotation == null)
			return true;
		
		int needRole = classAnnotation == null ? -1 : classAnnotation.requiredRole().getLevel();
		needRole = methodAnnotation == null ? needRole : methodAnnotation.requiredRole().getLevel();
		
		boolean isAPI = classAnnotation == null ? true : classAnnotation.type() == ControllerType.API;
		isAPI = methodAnnotation == null ? isAPI : methodAnnotation.type() == ControllerType.API;
		
		HttpSession session = request.getSession();
		Object object = session.getAttribute("userRole");
		if(object != null) {
			Integer userRole = (int)(short) object;
			if(userRole != null) {
				if(userRole >= needRole)
					return true;
			}
		}
		
		if(!isAPI) {
			response.sendRedirect("/User/log");
			return false;
		}
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);//设置为false
		String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(new Result(0, "需要登录", null));
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().write(jsonString);
		System.out.println(jsonString);
		return false;
	}

}
