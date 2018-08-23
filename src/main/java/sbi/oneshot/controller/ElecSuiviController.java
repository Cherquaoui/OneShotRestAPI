package sbi.oneshot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import sbi.oneshot.entities.ElecSuivi;
import sbi.oneshot.repositories.ElecSuiviRepository;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ElecSuiviController {

    @Autowired
    ElecSuiviRepository elecSuiviRepository;
    @RequestMapping("/elec")
    public List<ElecSuivi> getAllElec(){
        return elecSuiviRepository.findAll();
    }

    @GetMapping("/elec/{codeSite}")
    public ElecSuivi getElecSuivi(@PathVariable String codeSite){ return elecSuiviRepository.getOne(codeSite);
    }

    @PutMapping("/elec/{codeSite}")
    public ElecSuivi updateElecSuivi(@RequestBody ElecSuivi elec){
        return this.elecSuiviRepository.save(elec);
    }
}
