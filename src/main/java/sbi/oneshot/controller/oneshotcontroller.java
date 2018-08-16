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
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;



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

    @RequestMapping(value = "/go/{codeSite}",produces = {"application/hal+json"})
    public Go getGo(@PathVariable String codeSite){

        Go go;
        go=goRepository.getOne(codeSite);
        go.add((linkTo(methodOn(oneshotcontroller.class).getGo(codeSite)).withSelfRel()));
        go.add((linkTo(methodOn(oneshotcontroller.class).editGo(codeSite,go)).withRel("edit")));
        go.add(linkTo(methodOn(oneshotcontroller.class).getElec(codeSite)).withRel("elec"));

        go.add(linkTo(methodOn(oneshotcontroller.class).getAllElec()).withRel("electrification"));

        return go  ;
    }


    @PutMapping("/go/{codeSite}")
    public Go editGo(@PathVariable String codeSite, @RequestBody Go go){

        return goRepository.save(go);

    }

    @RequestMapping(value = "/go",method = RequestMethod.POST)
    public Go saveGo(@RequestBody Go go){
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



}
