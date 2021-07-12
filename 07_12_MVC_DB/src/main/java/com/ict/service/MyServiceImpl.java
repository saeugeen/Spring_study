package com.ict.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.dao.MyDAO;
import com.ict.vo.VO;

@Service("myServiceImpl")
public class MyServiceImpl implements MyService{
	@Autowired
	private MyDAO myDAO;
	
	@Override
	public List<VO> getList() throws Exception {
		return myDAO.getList();
	}
	@Override
	public int getInsert(VO vo) throws Exception {
		return myDAO.getInsert(vo);
	}
	@Override
	public VO getOneList(String idx) throws Exception {
		return myDAO.getOneList(idx);
	}
	@Override
	public int getDelete(String idx) throws Exception {
		return myDAO.getDelete(idx);
	}
	@Override
	public int getUpdate(VO vo) throws Exception {
		return myDAO.getUpdate(vo);
	}
}
