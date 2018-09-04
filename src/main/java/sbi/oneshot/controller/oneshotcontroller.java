package sbi.oneshot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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
public class oneshotcontroller {


    @Autowired
    private GoRepository goRepository;

    @Autowired
    private ElecTravRepository elecTravRepository;
    @Autowired
    private OneShotRepository oneShotRepository;


    @Autowired
    private AjouterGo ajouterGo;


    @RequestMapping("/go")
    public List<Go> getAllGo() {
        return goRepository.findAll();
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
    public List<OneShot> getAllOneShot() {
        return oneShotRepository.findAll();
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
