package com.ict.ex02;

public class Boy implements Person{
	// 소년
	// 컴퓨터를 부팅한다.         (공통관심)
	// 컴퓨터로 게임을 한다.      (핵심관심)
	// 컴퓨터로 영화보기를 한다.  (핵심관심)
	// 컴퓨터를 종료한다.         (공통관심)
	
	@Override
	public void doSomting() {
		System.out.println("컴퓨터로 게임을 한다.");
		System.out.println("=====================");
		System.out.println("컴퓨터로 영화보기를 한다.");
	}
}
