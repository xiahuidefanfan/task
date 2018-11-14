package com.team.tool.task.common.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.team.tool.task.common.support.RespData;

/**
 * @ClassName: SystemAuthenticationSuccessHandler.java
 * @Description: 登录成功处理机制
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年11月14日 下午7:51:20 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年11月14日     xiahui           v1.0.0         登录成功处理机制
 */
@Component("systemAuthenticationSuccessHandler")
public class SystemAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{

	private static final Logger LOGGER = LoggerFactory.getLogger(SystemAuthenticationSuccessHandler.class);

	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		LOGGER.info(authentication.getName() + "登录成功");
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().write(objectMapper.writeValueAsString(RespData.getRespData(true, authentication.toString(), "")));
	}
	
}