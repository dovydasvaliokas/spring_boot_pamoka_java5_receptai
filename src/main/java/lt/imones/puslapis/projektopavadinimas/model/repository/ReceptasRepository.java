package lt.imones.puslapis.projektopavadinimas.model.repository;

import lt.imones.puslapis.projektopavadinimas.model.entity.Receptas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceptasRepository  extends JpaRepository<Receptas, Long> {

    Receptas findByPavadinimas(String pavadinimas);

    Receptas findById(long id);

    List<Receptas> findByKainaBetween(Double pradineKaina, Double galutineKaina);


}
