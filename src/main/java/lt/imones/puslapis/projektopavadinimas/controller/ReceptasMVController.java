package lt.imones.puslapis.projektopavadinimas.controller;
import lt.imones.puslapis.projektopavadinimas.model.entity.Receptas;
import lt.imones.puslapis.projektopavadinimas.model.repository.ReceptasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ReceptasMVController {
    @Autowired
    ReceptasRepository receptasRepository;

    @GetMapping("/test/sveikinimas")
    String testineFunkcija(Model model, @RequestParam String vardas) {
        model.addAttribute("vardas", vardas);
        return "testinis_puslapis.html";
    }

    @GetMapping("/test/receptas")
    String testReceptas(Model model, @RequestParam String pavadinimas) {
        Receptas receptas = receptasRepository.findByPavadinimas(pavadinimas);
        model.addAttribute("pavadinimas", receptas.getPavadinimas());
        model.addAttribute("nurodymai", receptas.getNurodymai());
        model.addAttribute("kalorijosPer100g", receptas.getKalorijosPer100g());
        model.addAttribute("kaina", receptas.getKaina());
        model.addAttribute("receptoIngredientai", receptas.getReceptoIngredientai());
        model.addAttribute("receptoKurejas", receptas.getReceptoKurejas());
        model.addAttribute("receptoKategorija", receptas.getReceptoKategorija());
        return "parodyti_recepta.html";
    }

    @GetMapping("/test/paieska")
    String testPaieska(Model model) {
        return "rasti_recepta.html";
    }

    @GetMapping("/receptas/idejimas")
    String receptoIdejomas(Model model) {
        return "ideti_recepta.html";
    }

    @PostMapping("/recep/idejo_recepta")
    String pridetiRecepta(@RequestBody Receptas ivedamasReceptas) {
        receptasRepository.save(ivedamasReceptas);
        return "idetas_receptas.html";
    }
}
