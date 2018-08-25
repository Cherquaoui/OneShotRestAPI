package sbi.oneshot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import sbi.oneshot.entities.ElecSuivi;
import sbi.oneshot.entities.ElecTrav;
import sbi.oneshot.repositories.ElecSuiviRepository;
import sbi.oneshot.repositories.ElecTravRepository;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ElecController {

    @Autowired
    ElecSuiviRepository elecSuiviRepository;

    @Autowired
    ElecTravRepository elecTravRepository;

    @RequestMapping("/elec")
    public List<ElecSuivi> getAllElec() {
        return elecSuiviRepository.findAll();
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
}
