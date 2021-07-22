package com.ict.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ict.vo.BVO;
import com.ict.vo.CVO;

@Repository
public class MyDAOImpl implements MyDAO{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public int selectCount() throws Exception {
		return sqlSessionTemplate.selectOne("count");
	}

	@Override
	public List<BVO> selectBVOList(int begin, int end) throws Exception {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("begin", begin);
		map.put("end", end);
		return sqlSessionTemplate.selectList("list", map);
	}

	@Override
	public int insertBVO(BVO bvo) throws Exception {
		return sqlSessionTemplate.insert("insert", bvo);
	}

	@Override
	public int updateBVOHit(String b_idx) throws Exception {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.update("hitup",b_idx);
	}
	
	@Override
	public BVO selectBVOOneList(String b_idx) throws Exception {
		return sqlSessionTemplate.selectOne("onelist", b_idx);
	}
	
	@Override
	public List<CVO> selectCVOList(String b_idx) throws Exception {
		return sqlSessionTemplate.selectList("clist", b_idx);
	}

	@Override
	public int insertCVO(CVO cvo) throws Exception {
		return sqlSessionTemplate.insert("c_insert", cvo);
	}

	@Override
	public int deleteCVO(String c_idx) throws Exception {
		return sqlSessionTemplate.delete("c_delete", c_idx);
	}
	@Override
	public int deleteCVOComm_All(String b_idx) throws Exception {
		return sqlSessionTemplate.delete("c_delete_all", b_idx);
	}

	@Override
	public int deleteBVO(String b_idx) throws Exception {
		return sqlSessionTemplate.delete("delete", b_idx);
	}

	@Override
	public int selectPwdchk(BVO bvo) throws Exception {
		return sqlSessionTemplate.selectOne("pwd_chk", bvo);
	}
	
	@Override
	public int updateBVO(BVO bvo) throws Exception {
		return sqlSessionTemplate.update("update",bvo);
	}


	
	
}
