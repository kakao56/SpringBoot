package com.example.demo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DemoMapper {

	List<Map<String, Object>> getList(Map<String, Object> map) throws Exception;

	int getTotalCount(Map<String, Object> map) throws Exception;

	int upCnt(Map<String, Object> item) throws Exception;

	Map<String, Object> getDetail(Map<String, Object> map) throws Exception;

	int goDelet(List<String> delchk);

}
