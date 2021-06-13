package com.coredge.killbill.config;

import static com.coredge.killbill.utils.KillBillConstants.API_KEY_PARAMETER;
import static com.coredge.killbill.utils.KillBillConstants.API_SECRET_PARAMETER;
import static com.coredge.killbill.utils.KillBillConstants.CREATED_BY_PARAMETER;
import static com.coredge.killbill.utils.KillBillConstants.PASSWORD_PARAMETER;
import static com.coredge.killbill.utils.KillBillConstants.USERNAME_PARAMETER;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class HeaderRequestHandler implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String username = request.getHeader(USERNAME_PARAMETER);
		String password = request.getHeader(PASSWORD_PARAMETER);
		String apiKey = request.getHeader(API_KEY_PARAMETER);
		String apiSecret = request.getHeader(API_SECRET_PARAMETER);
		String createdBy = request.getHeader(CREATED_BY_PARAMETER);

		MDC.put(USERNAME_PARAMETER, username);
		MDC.put(PASSWORD_PARAMETER, password);
		MDC.put(API_KEY_PARAMETER, apiKey);
		MDC.put(API_SECRET_PARAMETER, apiSecret);
		MDC.put(CREATED_BY_PARAMETER, createdBy);

		return true;
	}
}
