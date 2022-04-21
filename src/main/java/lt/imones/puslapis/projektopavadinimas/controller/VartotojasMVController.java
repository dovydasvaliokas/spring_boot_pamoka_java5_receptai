package lt.imones.puslapis.projektopavadinimas.controller;

import lt.imones.puslapis.projektopavadinimas.model.repository.ReceptasRepository;
import lt.imones.puslapis.projektopavadinimas.model.repository.VartotojasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VartotojasMVController {
    @Autowired
    ReceptasRepository receptasRepository;

    @Autowired
    VartotojasRepository vartotojasRepository;

    @PostMapping("/vartotojas/pamego_recepta")
    String pamegtiRecepta(){

        return "pamegtas_receptas";
    }
}
