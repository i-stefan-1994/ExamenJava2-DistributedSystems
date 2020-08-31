package lib.rmi;

import lib.dto.CarsDto;
import lib.dto.DealershipDto;
import lib.dto.UserDto;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IDisplayService extends Remote {

    List<UserDto> getAllUsers() throws RemoteException;
    List<CarsDto> getCars() throws RemoteException;
    List<DealershipDto> getDealerships() throws RemoteException;

}
