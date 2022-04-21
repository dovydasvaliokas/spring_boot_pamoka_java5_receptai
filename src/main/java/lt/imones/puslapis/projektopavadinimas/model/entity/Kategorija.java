package lt.imones.puslapis.projektopavadinimas.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Kategorija {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String pavadinimas;

    @OneToMany(mappedBy = "receptoKategorija")
    private Set<Receptas> kategorijosReceptai;

    public Kategorija() {
    }

    public Kategorija(int id, String pavadinimas, Set<Receptas> kategorijosReceptai) {
        this.id = id;
        this.pavadinimas = pavadinimas;
        this.kategorijosReceptai = kategorijosReceptai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public Set<Receptas> getKategorijosReceptai() {
        return kategorijosReceptai;
    }

    public void setKategorijosReceptai(Set<Receptas> kategorijosReceptai) {
        this.kategorijosReceptai = kategorijosReceptai;
    }

    @Override
    public String toString() {
        return "Kategorija{" +
                "id=" + id +
                ", pavadinimas='" + pavadinimas + '\'' +
                ", kategorijosReceptai=" + kategorijosReceptai +
                '}';
    }
}
