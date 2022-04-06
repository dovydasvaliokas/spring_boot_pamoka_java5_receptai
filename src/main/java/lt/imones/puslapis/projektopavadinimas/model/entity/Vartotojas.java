package lt.imones.puslapis.projektopavadinimas.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Vartotojas {
    @Id
    @GeneratedValue
    long id;
    String username;
    String passsword;

    @JsonIgnore
    @OneToMany(mappedBy = "receptoKurejas")
    Set<Receptas> vartotojoReceptai;

    public Vartotojas() {
    }

    public Vartotojas(long id, String username, String passsword, Set<Receptas> vartotojoReceptai) {
        this.id = id;
        this.username = username;
        this.passsword = passsword;
        this.vartotojoReceptai = vartotojoReceptai;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasssword() {
        return passsword;
    }

    public void setPasssword(String passsword) {
        this.passsword = passsword;
    }

    public Set<Receptas> getVartotojoReceptai() {
        return vartotojoReceptai;
    }

    public void setVartotojoReceptai(Set<Receptas> vartotojoReceptai) {
        this.vartotojoReceptai = vartotojoReceptai;
    }

    @Override
    public String toString() {
        return "Vartotojas{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", passsword='" + passsword + '\'' +
                ", vartotojoReceptai=" + vartotojoReceptai +
                '}';
    }
}
