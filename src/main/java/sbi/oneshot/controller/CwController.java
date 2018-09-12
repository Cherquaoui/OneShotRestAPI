package sbi.oneshot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sbi.oneshot.entities.Cw;
import sbi.oneshot.entities.Equipe;
import sbi.oneshot.repositories.CwRepository;
import sbi.oneshot.repositories.EquipeRepository;

import java.util.List;

@RestController
@CrossOrigin("*")
public class CwController {

    @Autowired
    CwRepository cwRepository;

    @Autowired
    EquipeRepository equipeRepository;

    @RequestMapping("/cw")
    public List<Cw> getAllCw() {


        return cwRepository.findAll();
    }

    @GetMapping("/cw/{codeSite}")
    public Cw getCw(@PathVariable String codeSite) {
        return cwRepository.getOne(codeSite);
    }

    @PutMapping("/cw/{codeSite}")
    public Cw updateCw(@RequestBody Cw cw) {
        return this.cwRepository.save(cw);
    }
}
