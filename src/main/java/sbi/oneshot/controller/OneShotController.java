package sbi.oneshot.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import sbi.oneshot.entities.*;
import sbi.oneshot.entities.composition.OneShot;
import sbi.oneshot.repositories.*;
import sbi.oneshot.repositories.composition.OneShotRepository;
import java.util.List;

@RestController
@CrossOrigin("*")
public class OneShotController {

    @Autowired
    private GoRepository goRepository;

    @Autowired
    private OneShotRepository oneShotRepository;

    @Autowired
    private EquipeRepository equipeRepository;

    @GetMapping("/codesite")
    public String[] rechercherGo(@RequestParam(name = "codeSite", defaultValue = "") String codeSite,
                                 @RequestParam(name = "region", defaultValue = "") String region,
                                 @RequestParam(name = "typologie", defaultValue = "") String typologie) {
        return goRepository.rechercherGo(codeSite, region, typologie);
    }

    @RequestMapping("/oneshot")
    public Page<OneShot> rechercheOneShot(@RequestParam(name = "page", defaultValue = "0") int page,
                                          @RequestParam(name = "size", defaultValue = "15") int size,
                                          @RequestParam(name = "codeSite", defaultValue = "") String codeSite,
                                          @RequestParam(name = "region", defaultValue = "") String region,
                                          @RequestParam(name = "typologie", defaultValue = "") String typologie,
                                          @RequestParam(name = "etatCw", defaultValue = "") String etatCw,
                                          @RequestParam(name = "equipeCw", defaultValue = "") String equipeCw,
                                          @RequestParam(name = "etatElec", defaultValue = "") String etatElec,
                                          Sort sort
    ) {
        return oneShotRepository.rechercheOneShot(codeSite,region,typologie
                ,etatCw,equipeCw,etatElec,PageRequest.of(page,size,sort));
    }

    @GetMapping("/equipe")
    public List<Equipe> getEquipe(){
        return equipeRepository.findAll();
    }

}
