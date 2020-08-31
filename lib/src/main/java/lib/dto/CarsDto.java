package lib.dto;

import lib.model.Cars;

import java.io.Serializable;
import java.util.List;

public class CarsDto implements Serializable {

    private int id;

    private String name;

    private double price;

    private DealershipDto dealershipDto;

    private List<UserDto> userList;

    private Cars cars;

    public Cars getCars() {
        return cars;
    }

    public void setCars(Cars cars) {
        this.cars = cars;
    }

    public CarsDto(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }


    public CarsDto(int id, String name, double price, DealershipDto dealershipDto, UserDto userList) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.dealershipDto = dealershipDto;
        this.userList = List.of(userList);
    }

    public CarsDto(int id, String name, double price, UserDto userList) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.userList = List.of(userList);
    }

    public CarsDto() {

    }


    public List<UserDto> getUserList() {
        return userList;
    }

    public void setUserList(List<UserDto> userList) {
        this.userList = userList;
    }

    public DealershipDto getDealershipDto() {
        return dealershipDto;
    }

    public void setDealershipDto(DealershipDto dealershipDto) {
        this.dealershipDto = dealershipDto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Cars{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
