package lt.imones.puslapis.projektopavadinimas.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Vartotojas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String username;
    String password;
    private boolean enabled;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "vartotojo_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "receptoKurejas")
    Set<Receptas> vartotojoReceptai;

    public Vartotojas() {
    }

    public Vartotojas(long id, String username, String passsword, boolean enabled, Set<Role> roles, Set<Receptas> vartotojoReceptai) {
        this.id = id;
        this.username = username;
        this.password = passsword;
        this.enabled = enabled;
        this.roles = roles;
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

    public String getPassword() {
        return password;
    }

    public void setPasssword(String passsword) {
        this.password = passsword;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
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
                ", passsword='" + password + '\'' +
                ", vartotojoReceptai=" + vartotojoReceptai +
                '}';
    }
}
