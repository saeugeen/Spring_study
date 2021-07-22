package com.ict.service;

import java.util.List;

import com.ict.vo.BVO;
import com.ict.vo.CVO;

public interface MyService {
	int selectCount() throws Exception ;
	List<BVO> selectBVOList(int begin, int end) throws Exception;
	int insertBVO(BVO bvo) throws Exception;
	// 업데이트와 상세보기를 하나로 
    BVO updateBVO_selectBVOOneList(String b_idx) throws Exception;
	int deleteCVOComm_All(String b_idx) throws Exception;
	int deleteBVO(String b_idx) throws Exception;
	List<CVO> selectCVOList(String b_idx) throws Exception;
	int insertCVO(CVO cvo) throws Exception;
	int deleteCVO(String c_idx) throws Exception;
	// pwd 체크
	int selectPwdchk(BVO bvo) throws Exception;

	// 업데이트전에 정보 가져오기 
	BVO selectBVOOneList(String b_idx) throws Exception ;
	int updateBVO(BVO bvo) throws Exception;
	
}
