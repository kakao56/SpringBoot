package com.example.demo.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.demo.mapper.DemoMapper;
import com.example.demo.service.DemoService;
import com.example.demo.util.PageUtil;

@Service("service")
public class DemoServiceImpl implements DemoService{

	@Autowired
	private DemoMapper demoMaper;
	

	@Override
	public void getList(Map<String, Object> map, Model model) throws Exception {
		
		int nowPage =1, totalCount = 0, pagePerSize = 20, pagePerBlock = 5;
		
		Object o_nowPage = map.get("nowPage");
		Object o_searchT = map.get("searchType");
		
		if(o_nowPage != null) {
			try {
				nowPage = Integer.parseInt(o_nowPage.toString());
			} catch (Exception e) {
				nowPage = 1;
			}
		}

		if(o_searchT != null) {
			model.addAttribute("searchType", o_searchT);
			model.addAttribute("searchValue", map.get("searchValue"));
		}
		
		totalCount = demoMaper.getTotalCount(map);

		if(totalCount == 0) {
			//System.out.println("검색된 게시물 없음");
			return;
		}
			
		PageUtil page = new PageUtil(nowPage, totalCount, pagePerSize, pagePerBlock);
		
		map.put("pagePerSize", pagePerSize);
		map.put("begin", page.getBegin());
		
		List<Map<String, Object>> list = demoMaper.getList(map);

		model.addAttribute("list",list);
		model.addAttribute("pageCode",page.getPageCode());
		
	}


	@Override
	public void getDetail(Map<String, Object> map, Model model, HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		try {
			Integer.parseInt(map.get("seq").toString());
		}catch (Exception e) {
			map.put("seq",-1);
		}
		
		
		Map<String, Object> item =  demoMaper.getDetail(map);
		
		if(item == null) {
			return;
		}
		
		Cookie[] getCookies = req.getCookies();
		String seq = map.get("seq").toString();
		String tb = "bs";
		String tb_seq = tb+seq;
		boolean flag = false;
		
		if(getCookies != null) {
			for (Cookie c : getCookies) {
							
				if(tb_seq.equals(c.getName())) {
					flag = !flag;
					break;
				}
				
			}
		}
		
		if(!flag) {
			
			Cookie setCookie = new Cookie(tb_seq, seq);
			
			setCookie.setMaxAge(60*60*24);
			
			res.addCookie(setCookie);
			
			item.put("vCnt", Integer.parseInt(item.get("vCnt").toString())+1);
			
			int cnt = demoMaper.upCnt(item);
			
		}
		
		model.addAttribute("item",item);
			
	}


	@Override
	public void goDelete(List<String> delchk) {
		
		if(delchk.size() > 0) {
		
			int cnt = demoMaper.goDelet(delchk);
			
			if(cnt == 0 ) {
				System.out.println("삭제 오류");
			}
			
		}
		
	}

}





























