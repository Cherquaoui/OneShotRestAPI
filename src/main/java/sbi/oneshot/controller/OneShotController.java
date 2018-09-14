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
import sbi.oneshot.service.AjouterGo;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin("*")
public class OneShotController {

    @Autowired
    private GoRepository goRepository;

    @Autowired
    private OneShotRepository oneShotRepository;

    @Autowired
    private EquipeRepository equipeRepository;


    @Autowired
    private AjouterGo ajouterGo;


    @GetMapping("/go")
    public Page<Go> getAllGo(@RequestParam(defaultValue = "0", name = "index") int index,
                             @RequestParam(defaultValue = "15", name = "size") int size) {
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
                                @RequestParam(name = "size", defaultValue = "15") int size,
                                @RequestParam(name = "page", defaultValue = "0") int page,
                                @RequestParam(name = "region", defaultValue = "") String region,
                                @RequestParam(name = "typologie", defaultValue = "") String typologie,
                                Sort sort) {

        return goRepository.rechercher(mc, typologie, region, PageRequest.of(page, size,sort));

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




    @GetMapping("/go/{codeSite}")
    public Optional<Go> getGo(@PathVariable String codeSite) {
        return goRepository.findById(codeSite);
    }

    @GetMapping("/equipe")
    public List<Equipe> getEquipe(){
        return equipeRepository.findAll();
    }


}
