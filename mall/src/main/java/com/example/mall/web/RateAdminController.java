package com.example.mall.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class RateAdminController {
	
	@GetMapping("/rate")
	public String entrace(Model model,HttpServletRequest request,HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		Double rate = null;
		for(Cookie cookie : cookies) {
			if (cookie.getName().equals("rate")) {
				rate = Double.parseDouble(cookie.getValue());
			}
		}
		if (rate == null) {
			rate = 0.02;
			Cookie rateCookie = new Cookie("rate", rate+"");
			response.addCookie(rateCookie);
		}
		model.addAttribute("rate", rate);
		return "commission_rate_admin";
	}
	
	@PostMapping("/rate")
	public String adjustRate(@RequestParam("adjustRate") String adjustRate,HttpServletResponse response) {
		Double rate = Double.parseDouble(adjustRate) / 100.0;
		if (rate >= 1) {
			rate = 1.0;
		}
		Cookie rateCookie = new Cookie("rate", rate + "");
		response.addCookie(rateCookie);
		return "redirect:/admin/rate";
	}
}
