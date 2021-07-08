package com.ict.ex02;

public class TestMain {
	public static void main(String[] args) {
		Boy boy = new Boy();
		Gril gril = new Gril();
		
		PersonProxy proxy = new PersonProxy();
		
		// proxy.setPerson(boy);
		proxy.setPerson(gril);
		proxy.setBefore(new BeforeImpl());
		proxy.doPlay();
		proxy.setAfter(new AfterImpl());
		
	}
}
