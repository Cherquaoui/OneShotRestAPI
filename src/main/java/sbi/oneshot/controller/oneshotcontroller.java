package sbi.oneshot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sbi.oneshot.entities.*;
import sbi.oneshot.entities.composition.OneShot;
import sbi.oneshot.repositories.*;
import sbi.oneshot.repositories.composition.OneShotRepository;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;


@RestController
@CrossOrigin("*")
public class oneshotcontroller {


    @Autowired
    private GoRepository goRepository;
    @Autowired
    private CwRepository cwRepository;
    @Autowired
    private ElecSuiviRepository elecSuiviRepository;
    @Autowired
    private ElecTravRepository elecTravRepository;
    @Autowired
    private OneShotRepository oneShotRepository;


    @RequestMapping("/go")
    public List<Go> getAllGo(){
        return goRepository.findAll();
    }



    @PutMapping("/go/{codeSite}")
    public Go editGo(@PathVariable String codeSite, @RequestBody Go go){


        return goRepository.save(go);

    }

    @RequestMapping(value = "/go",method = RequestMethod.POST)
    public Go saveGo(@RequestBody Go go){
        if((goRepository.findById(go.getCodeSite()))!=null){
            return null;
        }

        return this.goRepository.save(go);
    }

    @RequestMapping("/oneshot")
    public List<OneShot> getAllOneShot(){
        return oneShotRepository.findAll();
    }

    @RequestMapping("/cw")
    public List<Cw> getAllCw(){
        return cwRepository.findAll();
    }

    @RequestMapping("/elec")
    public List<ElecSuivi> getAllElec(){
        return elecSuiviRepository.findAll();
    }

    @RequestMapping("/elec/trav")
    public List<ElecTrav> getAllTrav(){
        return elecTravRepository.findAll();
    }

    @GetMapping("/elec/{codeSite}")
    public ElecSuivi getElec(@PathVariable String codeSite){
        return elecSuiviRepository.getOne(codeSite);
    }
    @GetMapping("/go/{codeSite}")
    public Go getGo(@PathVariable String codeSite){
        return goRepository.getOne(codeSite);
    }



}
