package com.gj.rcp;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
import java.util.List;

import com.gj.model.PersonEntity;

public class PersonServiceImpl extends UnicastRemoteObject implements PersonService{

	protected PersonServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<PersonEntity> getlist() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("remote call begin");
		List<PersonEntity> personList=new LinkedList<PersonEntity>();
		personList.add(new PersonEntity(1,"name"));
		personList.add(new PersonEntity(2,"name1"));
		try {
			Thread.sleep(1000*30);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return personList;
		
	}

}
