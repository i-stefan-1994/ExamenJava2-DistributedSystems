package server.server;

import server.service.OrderService;
import server.service.DisplayService;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {

        try {
            Registry registry = LocateRegistry.createRegistry(4545);
            registry.rebind("displayService", new DisplayService());
            registry.rebind("orderService", new OrderService());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
