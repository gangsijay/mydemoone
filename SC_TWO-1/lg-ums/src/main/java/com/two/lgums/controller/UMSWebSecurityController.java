package com.two.lgums.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UMSWebSecurityController {
//	private RequestCache requestCache = new HttpSessionRequestCache();
//	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@RequestMapping(value ="/login")
	public String loginPage(ModelMap map) {
		return "login1";
	}
	
//	@GetMapping(value="/login")
//    public String loginPage1(ModelMap map){
//        return "login1"; //当浏览器输入/index时，会返回 /static/home.html的页面
//    }

	@RequestMapping(value ="/loginSuccess")
	public String login(ModelMap map) {

		return "success";
	}
	
	@RequestMapping(value ="/")
	public String loginHome(ModelMap map) {
		return "home";
	}

	/**
	 * 当需要身份认证的时候，跳转到这里
	 */
//	@RequestMapping(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
//	public String requireAuthentication(HttpServletRequest request, HttpServletResponse response)  {
//		SavedRequest savedRequest = requestCache.getRequest(request, response);
//		if (savedRequest != null) {
//			String targetUrl = savedRequest.getRedirectUrl();
//			if(StringUtils.endsWith(targetUrl, ".html")) {
//				return "index";
//			}
//		}
//		return "login";
//	}
}
