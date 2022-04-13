package lt.imones.puslapis.projektopavadinimas.controller;

import lt.imones.puslapis.projektopavadinimas.model.entity.Receptas;
import lt.imones.puslapis.projektopavadinimas.model.repository.ReceptasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReceptasController {

    @Autowired
    ReceptasRepository receptasRepository;

    @GetMapping("/recep/gauti_pav")
    Receptas gautiPagalPavadinima(@RequestParam String pavadinimas) {
        return receptasRepository.findByPavadinimas(pavadinimas);
    }

    @GetMapping("/recep/gauti_kaina_intervala")
    List<Receptas> gautiPagalKainosIntervala(Double pradineKaina, Double galutineKaina) {
        return receptasRepository.findByKainaBetween(pradineKaina, galutineKaina);
    }

    @PostMapping("/recep/ideti_recepta")
    String idetiRecepta(@RequestBody Receptas ivedamasReceptas) {
        receptasRepository.save(ivedamasReceptas);
        return "įdėjo";
    }

    @GetMapping("/new")
    String dawasdasd() {
        return "ASfdadfadfadf";
    }
}
