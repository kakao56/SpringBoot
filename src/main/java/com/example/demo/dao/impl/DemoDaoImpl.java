package com.example.demo.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.DemoDao;

@Repository("dao")
public class DemoDaoImpl implements DemoDao{

	@Autowired
	SqlSessionTemplate sst;

	@Override
	public List<Map<String, Object>> getList(Map<String, Object> map) {
		return sst.selectList("mapper.getList", map);
	}

	@Override
	public int getTotalCount(Map<String, Object> map) {
		return sst.selectOne("mapper.getTotalCount",map);
	}

	@Override
	public int upCnt(Map<String, Object> item) {
		return sst.update("mapper.upCnt",item);
	}

	@Override
	public Map<String, Object> getDetail(Map<String, Object> map) {
		return sst.selectOne("mapper.getDetail",map);
	}
}
