package lt.imones.puslapis.projektopavadinimas.model.repository;

import lt.imones.puslapis.projektopavadinimas.model.entity.Ingredientas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientasRepository extends JpaRepository<Ingredientas, Long> {
    Ingredientas findByPavadinimas(String pavadinimas);
}
