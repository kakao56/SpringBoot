package com.example.demo.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

public interface DemoService {

	void getList(Map<String, Object> map, Model model) throws Exception;

	void getDetail(Map<String, Object> map, Model model, HttpServletRequest req, HttpServletResponse res) throws Exception;

	void goDelete(List<String> delchk);

}
