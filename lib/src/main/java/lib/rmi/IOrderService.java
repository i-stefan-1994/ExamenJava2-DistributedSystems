package lib.rmi;

import lib.dto.CarsDto;
import lib.dto.DealershipDto;
import lib.dto.UserDto;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IOrderService extends Remote {

    boolean addOrder(DealershipDto dealershipDto, CarsDto carsDto, UserDto userDto) throws RemoteException;
}
