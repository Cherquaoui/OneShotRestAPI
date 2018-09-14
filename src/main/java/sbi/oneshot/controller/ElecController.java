package sbi.oneshot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import sbi.oneshot.entities.ElecSuivi;
import sbi.oneshot.entities.ElecTrav;
import sbi.oneshot.entities.composition.Electrification;
import sbi.oneshot.repositories.ElecSuiviRepository;
import sbi.oneshot.repositories.ElecTravRepository;
import sbi.oneshot.repositories.composition.ElectrificationRepository;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ElecController {

    @Autowired
    ElecSuiviRepository elecSuiviRepository;

    @Autowired
    ElecTravRepository elecTravRepository;

    @Autowired
    ElectrificationRepository electrificationRepository;

    @RequestMapping("/elec")
    public List<ElecSuivi> getAllElec() {
        return elecSuiviRepository.findAll();
    }

    @GetMapping("/electrification")
    public List<Electrification> getAllElectrification(){
        return electrificationRepository.findAll();
    }

    @GetMapping("/elec/{codeSite}")
    public ElecSuivi getElecSuivi(@PathVariable String codeSite) {
        return elecSuiviRepository.getOne(codeSite);
    }

    @PutMapping("/elec/{codeSite}")
    public ElecSuivi updateElecSuivi(@PathVariable String codeSite, @RequestBody ElecSuivi elec) {
        return this.elecSuiviRepository.save(elec);
    }

    @GetMapping("/elec/trav/{codeSite}")
    public ElecTrav getElecTrav(@PathVariable String codeSite) {
        return this.elecTravRepository.getOne(codeSite);
    }

    @PutMapping("/elec/trav/{codeSite}")
    public ElecTrav putElecTrav(@RequestBody ElecTrav elecTrav) {
        return this.elecTravRepository.save(elecTrav);
    }

    @RequestMapping("/elec/trav")
    public List<ElecTrav> getAllTrav() {
        return elecTravRepository.findAll();
    }
}
