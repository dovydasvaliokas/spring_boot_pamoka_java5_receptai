package lt.imones.puslapis.projektopavadinimas.model.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "vartotojo_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> vartotojai = new HashSet<>();

    public Role() {
    }

    public Role(Integer id, String name, Set<Role> vartotojai) {
        this.id = id;
        this.name = name;
        this.vartotojai = vartotojai;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Role> getVartotojai() {
        return vartotojai;
    }

    public void setVartotojai(Set<Role> vartotojai) {
        this.vartotojai = vartotojai;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", vartotojai=" + vartotojai +
                '}';
    }
}
