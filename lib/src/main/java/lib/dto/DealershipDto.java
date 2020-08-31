package lib.dto;

import lib.model.Cars;

import java.io.Serializable;
import java.util.List;

public class DealershipDto implements Serializable {

    private int id;
    private String name;
    private List<Cars> cars;

    public DealershipDto(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public DealershipDto(int id, String name, Cars cars) {
        this.id = id;
        this.name = name;
        this.cars = List.of(cars);
    }

    public DealershipDto() {

    }

    public List<Cars> getCars() {
        return cars;
    }

    public void setCars(List<Cars> cars) {
        this.cars = cars;
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

    @Override
    public String toString() {
        return "DealershipDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
