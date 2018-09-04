package sbi.oneshot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sbi.oneshot.entities.Cw;
import sbi.oneshot.entities.ElecSuivi;
import sbi.oneshot.entities.ElecTrav;
import sbi.oneshot.entities.Go;
import sbi.oneshot.repositories.CwRepository;
import sbi.oneshot.repositories.ElecSuiviRepository;
import sbi.oneshot.repositories.ElecTravRepository;
import sbi.oneshot.repositories.GoRepository;

@Service
@Transactional
public class AjouterGo {

    @Autowired
    private GoRepository goRepository;

    @Autowired
    private CwRepository cwRepository;

    @Autowired
    private ElecSuiviRepository elecSuiviRepository;

    @Autowired
    private ElecTravRepository elecTravRepository;

    public void saveGo(Go go){
        goRepository.save(go);
        cwRepository.save(new Cw(go.getCodeSite()));
        elecSuiviRepository.save(new ElecSuivi(go.getCodeSite()));
        elecTravRepository.save(new ElecTrav(go.getCodeSite()));


    }

}
