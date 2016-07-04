package com.gj;

public class Li {
	public void executeMessage(CallBack callback,String question) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		callback.solve("Li done");
	}

}
