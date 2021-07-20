package com.ict.dao;

import com.ict.vo.CVO;
import com.ict.vo.TVO;
import com.ict.vo.VO;

public interface MyDAO {
	void insertCard(VO vo) throws Exception;
	void insertTicket(VO vo) throws Exception;
	
	void insertCard(CVO cvo) throws Exception;
	void insertTicket(TVO tvo) throws Exception;
}
