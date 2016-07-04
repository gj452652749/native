package com.gj.test;

public class MulCallTest {

	/**
	 * @param args
	 */
	public void callBlock() {
		System.out.println("call begin");
		//while(true);
		try {
			Thread.sleep(1000*30);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MulCallTest test=new MulCallTest();
		test.callBlock();
		try {
			Thread.sleep(1000*3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
			
		}).start();
	}

}
