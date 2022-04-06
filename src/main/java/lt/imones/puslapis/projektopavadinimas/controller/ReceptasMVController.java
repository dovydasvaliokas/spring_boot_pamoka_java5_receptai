package lt.imones.puslapis.projektopavadinimas.controller;

import lt.imones.puslapis.projektopavadinimas.model.entity.Receptas;
import lt.imones.puslapis.projektopavadinimas.model.repository.ReceptasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReceptasMVController {
    @Autowired
    ReceptasRepository receptasRepository;

    @GetMapping("/th/rec/gauti")
    String gautiRecepta(Model model, @RequestParam String pavadinimas) {
        Receptas receptas = receptasRepository.findByPavadinimas(pavadinimas);
        model.addAttribute("pavadinimas", receptas.getPavadinimas());
        model.addAttribute("nurodymai", receptas.getNurodymai());
        model.addAttribute("kalorijosPer100g", receptas.getKalorijosPer100g());
        model.addAttribute("kaina", receptas.getKaina());
        return "gauti_recepta.html";
    }

    @GetMapping("/th/rec/ideti")
    String receptoIdejimoPuslapis(Model model) {
        Receptas receptas = new Receptas();
        model.addAttribute("receptas", receptas);
        return "ideti_recepta.html";
    }
}
