package com.ict.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.dao.MyDAO;
import com.ict.vo.VO;

@Service("myServiceImpl")
public class MyServiceImpl implements  MyService{
	@Autowired
	private MyDAO myDAO;
	
	@Override
	public List<VO> selectAll() throws Exception {
		return myDAO.selectAll();
	}
	
	@Override
	public int insert(VO vo) throws Exception {
		return myDAO.insert(vo);
	}
	@Override
	public VO selectOne(String idx) throws Exception {
		return myDAO.selectOne(idx);
	}
	
	@Override
	public int deleteOne(String idx) throws Exception {
		return myDAO.deleteOne(idx);
	}
	@Override
	public int updateOne(VO vo) throws Exception {
		return myDAO.updateOne(vo);
	}
}
