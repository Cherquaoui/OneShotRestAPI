package sbi.oneshot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import sbi.oneshot.entities.*;
import sbi.oneshot.entities.composition.OneShot;
import sbi.oneshot.repositories.*;
import sbi.oneshot.repositories.composition.OneShotRepository;
import sbi.oneshot.service.AjouterGo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


@RestController
@CrossOrigin("*")
public class OneShotController {


    @Autowired
    private GoRepository goRepository;

    @Autowired
    private ElecTravRepository elecTravRepository;
    @Autowired
    private OneShotRepository oneShotRepository;

    @Autowired
    private EquipeRepository equipeRepository;


    @Autowired
    private AjouterGo ajouterGo;


    @GetMapping("/go")
    public Page<Go> getAllGo(@RequestParam(defaultValue = "0", name = "index") int index,
                             @RequestParam(defaultValue = "10", name = "size") int size) {
        return goRepository.findAll(PageRequest.of(index, size));
    }

    @GetMapping("/codesite")
    public String[] rechercherGo(@RequestParam(name = "codeSite", defaultValue = "") String codeSite,
                                 @RequestParam(name = "region", defaultValue = "") String region,
                                 @RequestParam(name = "typologie", defaultValue = "") String typologie) {
        return goRepository.rechercherGo(codeSite, region, typologie);
    }

    @GetMapping("/go/recherche")
    public Page<Go> rechercheGo(@RequestParam(name = "codeSite", defaultValue = "") String mc,
                                @RequestParam(name = "size", defaultValue = "10") int size,
                                @RequestParam(name = "page", defaultValue = "0") int page,
                                @RequestParam(name = "region", defaultValue = "") String region,
                                @RequestParam(name = "typologie", defaultValue = "") String typologie) {

        return goRepository.rechercher(mc, typologie, region, PageRequest.of(page, size));

    }


    @PutMapping("/go/{codeSite}")
    public Go editGo(@PathVariable String codeSite, @RequestBody Go go) {
        return goRepository.save(go);

    }

    @PostMapping(value = "/go")

    public Optional<Go> saveGo(@RequestBody Optional<Go> go) {

        Optional<Go> monGo = goRepository.findById(go.get().getCodeSite());
        if (!monGo.isPresent()) {
            ajouterGo.saveGo(go.get());

            return go;
        }

        return null;
    }


    @RequestMapping("/oneshot")
    public Page<OneShot> rechercheOneShot(@RequestParam(name = "page", defaultValue = "0") int page,
                                          @RequestParam(name = "size", defaultValue = "10") int size,
                                          @RequestParam(name = "codeSite", defaultValue = "") String codeSite,
                                          @RequestParam(name = "region", defaultValue = "") String region,
                                          @RequestParam(name = "typologie", defaultValue = "") String typologie,
                                          @RequestParam(name = "etatCw", defaultValue = "") String etatCw
    ) {

        return oneShotRepository.rechercheOneShot(codeSite,region,typologie,etatCw,PageRequest.of(page,size));
    }




    @GetMapping("/go/{codeSite}")
    public Go getGo(@PathVariable String codeSite) {
        return goRepository.getOne(codeSite);
    }

    @GetMapping("/equipe")
    public List<Equipe> getEquipe(){
        return equipeRepository.findAll();
    }


}
