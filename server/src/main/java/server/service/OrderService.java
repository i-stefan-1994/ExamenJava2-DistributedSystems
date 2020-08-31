package server.service;


import lib.dto.CarsDto;
import lib.dto.DealershipDto;
import lib.dto.UserDto;
import lib.model.Cars;
import lib.model.Dealership;
import lib.model.User;
import lib.rmi.IOrderService;
import server.dao.CarsDao;
import server.dao.DealershipDao;
import server.dao.OrderDao;
import server.dao.UserDao;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.stream.Collectors;

public class OrderService extends UnicastRemoteObject implements IOrderService {

    private EntityManagerFactory emf;

    public OrderService() throws RemoteException {
        emf = Persistence.createEntityManagerFactory("javaExamenPU");
    }







    @Override
    public boolean addOrder(DealershipDto dealershipDto, CarsDto carsDto, UserDto userDto) throws RemoteException {
        EntityManager em = emf.createEntityManager();
        OrderDao dealershipDao = new OrderDao(em);
        Dealership dealership = new Dealership();
        UserDao userDao = new UserDao(em);
        Cars cars = new Cars();
        User user = new User();

        user.setUsername(userDto.getUsername());
        user.setTelefon(userDto.getTelefon());
        user.seteMail(userDto.getTelefon());

        cars.setName(carsDto.getName());
        cars.setPrice(carsDto.getPrice());
        cars.setUser(user);
        dealership.setName(dealershipDto.getName());
        dealership.setCars(List.of(cars));

        em.getTransaction().begin();
        dealershipDao.addOrder(dealership, cars, user);
        userDao.addUser(user);
        em.getTransaction().commit();

        return true;
    }


}
