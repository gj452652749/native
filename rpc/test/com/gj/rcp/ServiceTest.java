package com.gj.rcp;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import com.gj.model.PersonEntity;

public class ServiceTest {

	/**
	 * @param args
	 */
	public static String testFinal(String str){
		return str;
	}
	public static PersonEntity testFinalObj(PersonEntity bean){
		bean.setName("begin");
		return bean;
	}
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		// TODO Auto-generated method stub
//		String str="ok";
//		assert str==testFinal(str);
//		if(str==testFinal(str)) System.out.println("the same");
//		PersonEntity bean=new PersonEntity(12,"aa");
//		assert bean==testFinalObj(bean);
//		if(bean==testFinalObj(bean)) System.out.println("OBJ the same");		
			final PersonService personService=(PersonService) Naming.lookup("rmi://127.0.0.1:6600/PersonService");
			new Thread(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					List<PersonEntity> list;
					try {
						list = personService.getlist();
						for(PersonEntity entity:list)
							System.out.println(entity.getId()+":"+entity.getName());
						System.out.println(list);
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}					
				}				
			}).start();
			new Thread(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					List<PersonEntity> list;
					try {
						list = personService.getlist();
						for(PersonEntity entity:list)
							System.out.println(entity.getId()+":"+entity.getName());
						System.out.println(list);
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}					
				}				
			}).start();
	}
			

}
