package lt.imones.puslapis.projektopavadinimas.controller;

import lt.imones.puslapis.projektopavadinimas.model.entity.Kategorija;
import lt.imones.puslapis.projektopavadinimas.model.repository.KategorijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class KategorijaMVController {
    @Autowired
    KategorijaRepository kategorijaRepository;

    @GetMapping("/test/visos_kategorijos")
    String rodytiVisasKategorijas(Model model) {
        List<Kategorija> visosKategorijos = kategorijaRepository.findAll();
        model.addAttribute("visosKategorijos", visosKategorijos);
        return "visos_kategorijos.html";
    }

    @GetMapping("/kategorija/rodyti_receptus")
    String rodytiKategorijosReceptus(Model model, @RequestParam int id) {
        Kategorija kategorija = kategorijaRepository.findById(id);
        model.addAttribute("kategorijosReceptai", kategorija.getKategorijosReceptai());
        model.addAttribute("kategorijosPavadinimas", kategorija.getPavadinimas());
        return "kategorijos_receptai.html";
    }

    @GetMapping("/kategorija/kategorijos_idejimas")
    String kategorijosPridejimas(Model model) {
        return "ideti_kategorija.html";
    }

    @PostMapping("/kategorija/ideta_kategorija")
    String idetiKategorija(@RequestParam String pavadinimas) {
        Kategorija naujaKategorija = new Kategorija();
        naujaKategorija.setPavadinimas(pavadinimas);
        kategorijaRepository.save(naujaKategorija);
        return "ideta_kategorija.html";
    }
}
