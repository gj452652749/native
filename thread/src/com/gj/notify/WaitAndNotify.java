package com.gj.notify;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WaitAndNotify {
    private static List<Double> queue;
    public WaitAndNotify(){
        queue = new ArrayList<Double>();
    }
    
    public void begin(){
        Thread producer = new Thread(){
            public void run(){
                while(true){
                    synchronized(queue){
                        double time = 1.0d;
                    long startTime = System.currentTimeMillis();           
                    if(System.currentTimeMillis()-startTime>=time){
                            startTime =System.currentTimeMillis();
                        for(int i=0;i<10;i++){
                                queue.add((Math.random()*10000));
                        }
                    queue.notifyAll();
                    } 
                    }
                }
            }
        };
        producer.start();
        
        Thread consumer = new Thread(){
             public void run(){
                while(true){
                    synchronized(queue){
                        while(queue.isEmpty()){
                            System.out.println("队列的长度为:"+queue.size());
                            try {
                                queue.wait();
                            } catch (InterruptedException ex) {
                                Logger.getLogger(WaitAndNotify.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        double result = queue.remove(0);
                        System.out.println("成功从队列中取到数据！"+result);
                    }
                }
            }
        };
        consumer.start();  
        synchronized (this) {
        try {
			this.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }
    }  
       
    public static void main(String[] args){
        WaitAndNotify obj = new WaitAndNotify();
        queue.add(0.1231d);
        obj.begin();
    }
}