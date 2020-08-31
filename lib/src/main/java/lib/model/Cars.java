package lib.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "cars")
public class Cars implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private double price;

    @ManyToMany(mappedBy = "cars")
    private List<Dealership> orders;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    public Cars() {

    }

    public Cars(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Cars(int id, String name, double price, List<Dealership> orders, User user) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.orders = orders;
        this.user = user;
    }



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public List<Dealership> getOrders() {
        return orders;
    }

    public void setOrders(List<Dealership> orders) {
        this.orders = orders;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Cars{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", orders=" + orders +
                ", user=" + user +
                '}';
    }
}
