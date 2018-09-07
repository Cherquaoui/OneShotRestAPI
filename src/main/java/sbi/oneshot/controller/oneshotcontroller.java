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

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


@RestController
@CrossOrigin("*")
public class oneshotcontroller {


    @Autowired
    private GoRepository goRepository;

    @Autowired
    private ElecTravRepository elecTravRepository;
    @Autowired
    private OneShotRepository oneShotRepository;


    @Autowired
    private AjouterGo ajouterGo;


    @GetMapping("/go")
    public Page<Go> getAllGo(@RequestParam(defaultValue = "0", name = "index") int index,
                             @RequestParam(defaultValue = "10", name = "size") int size) {
        return goRepository.findAll(PageRequest.of(index, size));
    }

    @GetMapping("/codesite")
    public String[] rechercherGo(@RequestParam(name = "code", defaultValue = "") String site) {
        return goRepository.rechercherGo(site);
    }

    @GetMapping("/go/recherche")
    public Page<Go> rechercheGo(@RequestParam(name = "codeSite", defaultValue = "") String mc,
                                @RequestParam(name = "size", defaultValue = "10") int size,
                                @RequestParam(name = "index", defaultValue = "0") int index,
                                @RequestParam(name = "region", defaultValue = "") String region,
                                @RequestParam(name = "typologie", defaultValue = "") String typologie) {

        return goRepository.rechercher(mc, typologie, region, PageRequest.of(index, size));

    }


    @PutMapping("/go/{codeSite}")
    public Go editGo(@PathVariable String codeSite, @RequestBody Go go) {
        return goRepository.save(go);

    }

    @RequestMapping(value = "/go", method = RequestMethod.POST)

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
                                                   @RequestParam(name = "etatCw",defaultValue = "") String etatCw
                                     ) {
        List<OneShot> filtrage = oneShotRepository.
                rechercheOneShot(codeSite,etatCw)
                .stream().filter(new Predicate<OneShot>() {
            @Override
            public boolean test(OneShot oneShot) {
                System.out.println(oneShot.getCodeSite());
                return oneShot.getCw().getCodeSite().contains("AS");
            }
        }).collect(toList());

        filtrage.forEach(name-> System.out.println("habiiiiiib"+name.getCodeSite()));
        Page<OneShot> mapage = new PageImpl<>(filtrage, PageRequest.of(page, 10),filtrage.size());


        return mapage;
    }


    @RequestMapping("/elec/trav")
    public List<ElecTrav> getAllTrav() {
        return elecTravRepository.findAll();
    }


    @GetMapping("/go/{codeSite}")
    public Go getGo(@PathVariable String codeSite) {
        return goRepository.getOne(codeSite);
    }


}
