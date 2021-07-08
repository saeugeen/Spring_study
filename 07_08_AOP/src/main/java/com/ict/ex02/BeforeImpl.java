package com.ict.ex02;

public class BeforeImpl implements Before{
	@Override
	public void pre() {
		System.out.println("컴퓨터 부팅한다.");
	}
}
