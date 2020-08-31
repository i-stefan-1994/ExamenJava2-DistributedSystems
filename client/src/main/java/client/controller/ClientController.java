package client.controller;

import lib.dto.CarsDto;
import lib.dto.DealershipDto;
import lib.dto.UserDto;
import lib.rmi.IOrderService;
import lib.rmi.IDisplayService;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class ClientController {

    IOrderService orderService;
    IDisplayService displayService;

    private ClientController(){

        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 4545);
            orderService = (IOrderService) registry.lookup("orderService");
            displayService = (IDisplayService) registry.lookup("displayService");
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }

    }

    private static final class SingletonHolder{
        private final static ClientController INSTANCE = new ClientController();
    }

    public static ClientController getInstance(){
        return SingletonHolder.INSTANCE;
    }

    public List<CarsDto> getCars(){
        try {
            return displayService.getCars();
        } catch (RemoteException e) {
            throw new RuntimeException();
        }
    }


    public List<DealershipDto> getDealerships(){
        try {
            return displayService.getDealerships();
        } catch (RemoteException e) {
            throw new RuntimeException();
        }
    }



    public boolean addOrder(DealershipDto dealershipDto, CarsDto carsDto, UserDto userDto){
        try {
            orderService.addOrder(dealershipDto, carsDto, userDto);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }



    public List<UserDto> getAllUsers(){

        try {
            return displayService.getAllUsers();
        } catch (RemoteException e) {
            throw new RuntimeException();
        }

    }


}
