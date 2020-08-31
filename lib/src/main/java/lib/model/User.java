package lib.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity()
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;


    @OneToMany(mappedBy = "user")
    private List<Cars> orders;

    @ElementCollection
    private List<String> telefon;

    @ElementCollection
    private List<String> eMail;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    public List<Cars> getOrders() {
        return orders;
    }

    public void setOrders(List<Cars> orders) {
        this.orders = orders;
    }

    public List<String> getTelefon() {
        return telefon;
    }

    public void setTelefon(List<String> telefon) {
        this.telefon = telefon;
    }

    public List<String> geteMail() {
        return eMail;
    }

    public void seteMail(List<String> eMail) {
        this.eMail = eMail;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", orders=" + orders +
                ", telefon=" + telefon +
                ", eMail=" + eMail +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return id == user.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
