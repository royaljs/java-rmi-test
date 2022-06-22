package dev.jiwonlee.java.rmi.server;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import dev.jiwonlee.java.rmi.IService;

public class Server extends UnicastRemoteObject implements IService {

    public Server() throws RemoteException {
        super();
    }

    public String call(String message) {
        System.out.println("[Client] client: " + message);
        String response = "I'm fine.";
        System.out.println("[Server] server: " + response);
        return response;
    }

    public static void main(String args[]) {
        int port = Integer.parseInt(args[0]);
        System.out.println("[Server] Starting...");
        try {
            Server server = new Server();
            System.out.printf("[RMI Registry] Starting with port %d ...\n", port);
            Registry registry = LocateRegistry.createRegistry(port);
            System.out.println("[RMI Registry] Created.");
            try {
                registry.bind("test-rmi-server", server);
                System.err.println("[Server] Started.");
                while (true);
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