package com.ict.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.dao.MyDAO;
import com.ict.vo.BVO;
import com.ict.vo.CVO;

@Service
public class MyServiceImpl implements MyService{
	@Autowired
	private MyDAO myDAO ;
	
	@Override
	public int selectCount() throws Exception {
		return myDAO.selectCount();
	}

	@Override
	public List<BVO> selectBVOList(int begin, int end) throws Exception {
		return myDAO.selectBVOList(begin, end);
	}

	@Override
	public int insertBVO(BVO bvo) throws Exception {
		return myDAO.insertBVO(bvo);
	}

	@Override
	public BVO updateBVO_selectBVOOneList(String b_idx) throws Exception {
		 int result = myDAO.updateBVOHit(b_idx);
		 BVO bvo = myDAO.selectBVOOneList(b_idx);
		return bvo;
	} 

	@Override
	public List<CVO> selectCVOList(String b_idx) throws Exception {
		return myDAO.selectCVOList(b_idx);
	}

	@Override
	public int insertCVO(CVO cvo) throws Exception {
		return myDAO.insertCVO(cvo);
	}

	@Override
	public int deleteCVO(String c_idx) throws Exception {
		return myDAO.deleteCVO(c_idx);
	}
	
	@Override
	public int deleteCVOComm_All(String b_idx) throws Exception {
		return myDAO.deleteCVOComm_All(b_idx);
	}

	@Override
	public int deleteBVO(String b_idx) throws Exception {
		return myDAO.deleteBVO(b_idx);
	}
	@Override
	public int selectPwdchk(BVO bvo) throws Exception {
		return myDAO.selectPwdchk(bvo);
	}
	// 업데이트 전 정보 가져오기 
	@Override
	public BVO selectBVOOneList(String b_idx) throws Exception {
		return myDAO.selectBVOOneList(b_idx);
	}
	@Override
	public int updateBVO(BVO bvo) throws Exception {
		return myDAO.updateBVO(bvo);
	}

	


}
