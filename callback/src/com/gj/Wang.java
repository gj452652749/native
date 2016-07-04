package com.gj;

import org.junit.Test;

public class Wang implements CallBack{
	private Li li;

	public Wang(Li li) {
		super();
		this.li = li;
	}
@Test
	public void doAsk() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				li.executeMessage(Wang.this, "joney");
			}
		}).start();
		System.out.println("do something else");
	}
	@Override
	public void solve(String result) {
		// TODO Auto-generated method stub
		
		System.out.println("great"+result);
	}

}
