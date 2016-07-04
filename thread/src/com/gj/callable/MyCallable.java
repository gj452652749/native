package com.gj.callable;

import java.util.Random;
import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer>{
	private String name;
	

	public MyCallable(String name) {
		super();
		this.name = name;
	}


	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("runing");
		Thread.sleep(3000);
		int count=new Random().nextInt(300);
		return count;
	}
	

}
