package sbi.oneshot.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import sbi.oneshot.entities.Go;
import sbi.oneshot.repositories.GoRepository;
import sbi.oneshot.service.AjouterGo;
import java.util.Optional;

@RestController
public class GoController {

    @Autowired
    private GoRepository goRepository;

    @Autowired
    private AjouterGo ajouterGo;

    @GetMapping("/go")
    public Page<Go> getAllGo(@RequestParam(defaultValue = "0", name = "index") int index,
                             @RequestParam(defaultValue = "15", name = "size") int size) {
        return goRepository.findAll(PageRequest.of(index, size));
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
    public Go editGo( @RequestBody Go go) {
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

    @GetMapping("/go/{codeSite}")
    public Optional<Go> getGo(@PathVariable String codeSite) {
        return goRepository.findById(codeSite);
    }
}
