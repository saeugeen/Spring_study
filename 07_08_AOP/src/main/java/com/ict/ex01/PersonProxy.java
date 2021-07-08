package com.ict.ex01;

public class PersonProxy {
	private Person person ;
	
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	public void doPlay() {
		try {
			System.out.println("컴퓨터를 부팅한다.");
			// 스레드처리를 하기 위해서 강제로 만듦
			//int result = 15/0 ;
			person.doSomting();
		} catch (Exception e) {
			System.out.println("부모님이 오셨다.");
		}finally {
			System.out.println("컴퓨터를 종료시킨다.");
			System.out.println("공부를 한다.");
		}
	}
}
