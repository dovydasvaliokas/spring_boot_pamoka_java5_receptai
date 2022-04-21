package lt.imones.puslapis.projektopavadinimas.controller;
import lt.imones.puslapis.projektopavadinimas.model.entity.Kategorija;
import lt.imones.puslapis.projektopavadinimas.model.entity.Receptas;
import lt.imones.puslapis.projektopavadinimas.model.repository.KategorijaRepository;
import lt.imones.puslapis.projektopavadinimas.model.repository.ReceptasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class ReceptasMVController {
    @Autowired
    ReceptasRepository receptasRepository;

    @Autowired
    KategorijaRepository kategorijaRepository;

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
        model.addAttribute("id", receptas.getId());
        return "parodyti_recepta.html";
    }

    @GetMapping("/test/paieska")
    String testPaieska(Model model) {
        return "rasti_recepta.html";
    }

    @GetMapping("/receptas/idejimas")
    String receptoIdejomas(Model model) {
        Receptas receptas = new Receptas();
        model.addAttribute("receptas", receptas);
        model.addAttribute("kategorijos", kategorijaRepository.findAll());
        return "ideti_recepta.html";
    }


    @PostMapping("/recep/idejo_recepta")
    String pridetiRecepta(@ModelAttribute Receptas ivedamasReceptas) {
        receptasRepository.save(ivedamasReceptas);
        return "idetas_receptas.html";
    }


    @GetMapping("/recep/redaguoti_recepta/{id}")
    String redaguotiRecepta(Model model, @PathVariable long id) {
        Receptas receptas = receptasRepository.findById(id);
        model.addAttribute("receptas", receptas);
        model.addAttribute("kategorijos", kategorijaRepository.findAll());
        return "recepto_redagavimas.html";
    }

    @PostMapping("/recep/istrinti_recepta/{id}")
    String istrintiRecepta(Model model, @PathVariable long id) {
        receptasRepository.delete(receptasRepository.findById(id));
        return "istrintas_receptas.html";
    }
}
