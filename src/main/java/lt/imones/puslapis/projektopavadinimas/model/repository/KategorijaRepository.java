package lt.imones.puslapis.projektopavadinimas.model.repository;

import lt.imones.puslapis.projektopavadinimas.model.entity.Kategorija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;

@Repository
public interface KategorijaRepository extends JpaRepository<Kategorija, Integer> {
    Kategorija findById(int id);
}
