package dev.jiwonlee.java.rmi;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements IService {

    public Server() throws RemoteException {
        super();
    }

    public String call(String message) {
        System.out.println("[Server] Client request message: " + message);
        return message;
    }

    public static void main(String args[]) {
        System.out.println("[Server] Starting...");
        try {
            Server server = new Server();
            Registry registry = LocateRegistry.getRegistry();
            try {
                registry.bind("test-rmi-server", server);
                System.err.println("[Server] Started.");
                while (true)
                    ;
            } catch (Exception e) {
                System.err.println("[Server] Exception: " + e.toString());
                e.printStackTrace();
            } finally {
                registry.unbind("test-rmi-server");
            }
        } catch (Exception e) {
            System.err.println("[Server] Exception: " + e.toString());
            e.printStackTrace();
        }
    }
}