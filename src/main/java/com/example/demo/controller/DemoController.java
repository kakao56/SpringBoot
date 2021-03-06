package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.DemoService;

@Controller
public class DemoController {

	@Resource(name="service")
	private DemoService demoService;
	
	@RequestMapping("/")
	public @ResponseBody String home() {
		return "환영합니다";
	}

	@RequestMapping("list")
	public String list(@RequestParam Map<String, Object> map, Model model) throws Exception {
		demoService.getList(map, model);
		return "list";
	}
	
	@RequestMapping("detail")
	public String detail(@RequestParam Map<String, Object> map, Model model, HttpServletRequest req, HttpServletResponse res) throws Exception {
		demoService.getDetail(map, model, req, res);
		return "detail";
	}
	
	@RequestMapping("delete")
	public String delete(@RequestParam List<String> delchk) throws Exception {
		demoService.goDelete(delchk);
		return "redirect:list";
	}

	
	
}
