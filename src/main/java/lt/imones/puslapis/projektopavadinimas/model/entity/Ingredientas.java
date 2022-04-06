package lt.imones.puslapis.projektopavadinimas.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Ingredientas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String pavadinimas;
    private int kalorijosPer100g;
    private double kaina;

    @ManyToMany
    @JoinTable(
            name = "sujungimas_receptas_ingredientas",
            joinColumns = @JoinColumn(name = "ingredientas_id"),
            inverseJoinColumns = @JoinColumn(name = "receptas_id"))
    private Set<Receptas> ingredientaiReceptuose;


    public Ingredientas() {
    }

    public Ingredientas(long id, String pavadinimas, int kalorijosPer100g, double kaina) {
        this.id = id;
        this.pavadinimas = pavadinimas;
        this.kalorijosPer100g = kalorijosPer100g;
        this.kaina = kaina;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public int getKalorijosPer100g() {
        return kalorijosPer100g;
    }

    public void setKalorijosPer100g(int kalorijosPer100g) {
        this.kalorijosPer100g = kalorijosPer100g;
    }

    public double getKaina() {
        return kaina;
    }

    public void setKaina(double kaina) {
        this.kaina = kaina;
    }

    @Override
    public String toString() {
        return "Ingredientas{" +
                "id=" + id +
                ", pavadinimas='" + pavadinimas + '\'' +
                ", kalorijosPer100g=" + kalorijosPer100g +
                ", kaina=" + kaina +
                '}';
    }
}

