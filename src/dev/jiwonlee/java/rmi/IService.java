package dev.jiwonlee.java.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IService extends Remote {
    String call(String message) throws RemoteException;
}