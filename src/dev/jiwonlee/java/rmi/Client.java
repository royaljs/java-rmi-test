package dev.jiwonlee.java.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    private Client() {
    }

    public static void main(String[] args) {
        try {
            String host = (args.length < 1) ? "localhost" : args[0];
            int port = 1099;

            Registry registry = LocateRegistry.getRegistry(host, port);

            IService stub = (IService) registry.lookup("test-rmi-server");

            System.out.println("Server response: " + stub.call("Hello World!"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
