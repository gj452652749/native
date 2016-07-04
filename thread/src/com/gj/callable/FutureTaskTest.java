package com.gj.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyCallable call1=new MyCallable("1");
		FutureTask<Integer> result1=new FutureTask<Integer>(call1);
		Thread thread1=new Thread(result1);
		thread1.start();
		try {
			System.out.println(result1.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("that's ok");
		
	}

}
