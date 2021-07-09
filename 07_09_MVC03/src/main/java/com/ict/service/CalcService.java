package com.ict.service;

import org.springframework.stereotype.Service;

//Service : DB 트랜잭션처리, DB결과를 가공
//DAO : DB 결과 받기
@Service("calc")
public class CalcService {
	public int plus() {
		return 5+3;
	}
	public int minus() {
		return 5-3;
	}
	public int multi() {
		return 5*3;
	}
	public int divice() {
		return 5/3;
	}
}
