package lt.imones.puslapis.projektopavadinimas.controller;

import lt.imones.puslapis.projektopavadinimas.model.entity.Kategorija;
import lt.imones.puslapis.projektopavadinimas.model.repository.KategorijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KategorijaController {
    @Autowired
    KategorijaRepository kategorijaRepository;

    @PostMapping("/kategorija/ideti")
    String idetiKategorija(String pavadinimas) {
        Kategorija naujaKategorija = new Kategorija();
        naujaKategorija.setPavadinimas(pavadinimas);
        kategorijaRepository.save(naujaKategorija);
        return "Kategorija" + pavadinimas + " sėkmingai įdėta";
    }

    @GetMapping("/gauti/kategorija")
    String belekas() {
        return "belekas";
    }
}
