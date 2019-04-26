package com.example.demo.dao;

import java.util.List;
import java.util.Map;

public interface DemoDao {

	List<Map<String, Object>> getList(Map<String, Object> map);

	int getTotalCount(Map<String, Object> map);

	int upCnt(Map<String, Object> item);

	Map<String, Object> getDetail(Map<String, Object> map);

}
