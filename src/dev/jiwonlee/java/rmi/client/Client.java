package dev.jiwonlee.java.rmi.client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import dev.jiwonlee.java.rmi.IService;

public class Client {
    private Client() {
    }

    public static void main(String[] args) {
        try {
            String host = args[0];
            int port = Integer.parseInt(args[1]);
            Registry registry = LocateRegistry.getRegistry(host, port);

            IService stub = (IService) registry.lookup("test-rmi-server");
            String request = "How are you?";
            System.out.println("I: " + request);
            String response = stub.call(request);
            System.out.println("Server: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
