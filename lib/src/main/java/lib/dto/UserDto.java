package lib.dto;

import java.io.Serializable;
import java.util.List;

public class UserDto implements Serializable {
    private int id;
    private String username;
    private List<String> telefon;
    private List<String> eMail;



    public UserDto() {

    }


    public UserDto(int id, String username, String telefon, String eMail) {
        this.id = id;
        this.username = username;
        this.telefon = List.of(telefon);
        this.eMail = List.of(eMail);
    }

    public UserDto(int id, String username) {
        this.id = id;
        this.username = username;
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


    @Override
    public String toString() {
        return "Users: {" +
                "id=" + id +
                ", name ='" + username + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDto userDto = (UserDto) o;

        return id == userDto.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
