package com.ict.dao;

import java.util.List;

import com.ict.vo.VO;

public interface MyDAO {
	List<VO> selectAll() throws Exception;
	int insertGuestBook2(VO vo) throws Exception;
	VO selectOne(String idx) throws Exception;
	void updateGuestBook2(VO vo) throws Exception;
	void deleteGuestBook2(String idx) throws Exception ;
}
