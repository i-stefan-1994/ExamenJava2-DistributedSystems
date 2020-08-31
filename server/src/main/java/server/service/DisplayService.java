package server.service;

import lib.dto.CarsDto;
import lib.dto.DealershipDto;
import lib.dto.UserDto;
import lib.rmi.IDisplayService;
import server.dao.CarsDao;
import server.dao.DealershipDao;
import server.dao.UserDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.stream.Collectors;

public class DisplayService extends UnicastRemoteObject implements IDisplayService {

    private EntityManagerFactory emf;

    public DisplayService() throws RemoteException {
        emf = Persistence.createEntityManagerFactory("javaExamenPU");
    }

    @Override
    public List<UserDto> getAllUsers() {
        EntityManager em = emf.createEntityManager();
        UserDao userDao = new UserDao(em);

        return userDao.getUsers()
                .stream()
                .map(user -> new UserDto(user.getId(), user.getUsername()))
                .collect(Collectors.toList());
    }

    @Override
    public List<DealershipDto> getDealerships() throws RemoteException {
        EntityManager em = emf.createEntityManager();
        DealershipDao dealershipDao = new DealershipDao(em);
        return dealershipDao.getDealerships()
                .stream()
                .map(d -> new DealershipDto(d.getId(), d.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public List<CarsDto> getCars() throws RemoteException {
        EntityManager em = emf.createEntityManager();
        CarsDao carsDao = new CarsDao(em);
        return carsDao.getCars()
                .stream()
                .map(c -> new CarsDto(c.getId(), c.getName(), c.getPrice()))
                .collect(Collectors.toList());
    }
}
