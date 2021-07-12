package com.ict.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ict.vo.VO;

@Repository("myDAOImpl")
public class MyDAOImpl implements MyDAO{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	@Override
	public List<VO> getList() throws Exception {
		return sqlSessionTemplate.selectList("guestbook.list");
	}
	@Override
	public int getInsert(VO vo) throws Exception {
		return sqlSessionTemplate.insert("guestbook.insert",vo);
	}
	@Override
	public VO getOneList(String idx) throws Exception {
		return sqlSessionTemplate.selectOne("guestbook.onelist", idx);
	}
	@Override
	public int getDelete(String idx) throws Exception {
		return sqlSessionTemplate.delete("guestbook.delete",idx);
	}
	@Override
	public int getUpdate(VO vo) throws Exception {
		return sqlSessionTemplate.update("guestbook.update",vo);
	}
}
