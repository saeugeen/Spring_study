package com.ict.ex03;

// advice = 공통관심사를 모아 놓은 것
public class MyAspect {
	
	// 핵심관심사 전 : Before advice
	public void pre() {
		System.out.println("컴퓨터 부팅하기 ");
	}
	
	// 핵심관심사 성공 후: After returning advice
	public void next() {
		System.out.println("컴퓨터 종료하기 ");
	}
	// 핵심관심사 예외처리 후: After throwing advice
	public void next_throwing() {
		System.out.println("부모님이 오셨다.");
	}
	// 핵심관심사 성공 및 예외처리 상관없이 : After (finally) advice
	public void next_finally() {
		System.out.println("부모님이 오셨다.");
	}
	// 핵심관심사 실행 전, 후  : Around advice
	public void around() {
		System.out.println("실행 전, 실행 후");
	}
	
}
