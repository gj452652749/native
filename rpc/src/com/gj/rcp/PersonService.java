package com.gj.rcp;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import com.gj.model.PersonEntity;

public interface PersonService extends Remote{
	public List<PersonEntity> getlist() throws RemoteException;

}
