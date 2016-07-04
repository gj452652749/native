package com.gj.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;

public class FutureTest {

	/**
	 * @param args
	 */
	@Test
	public void equalsObj() {
		Thread a=new Thread();
		Thread c=new Thread();
		Thread b=a;
		assert b==c;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService executor=Executors.newCachedThreadPool();
		MyCallable call1=new MyCallable("1");
		MyCallable call2=new MyCallable("2");
		Future<Integer> result1=executor.submit(call1);
		Future<Integer> result2=executor.submit(call2);
		try {
		//	System.out.println(result1.get());
			System.out.println(result2.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		synchronized (mutex) {
//			
//		}
		System.out.println("ok");

	}

}
