package sbi.oneshot.repositories.composition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sbi.oneshot.entities.composition.OneShot;


import java.util.List;

public interface OneShotRepository extends JpaRepository<OneShot,String> {


    @Query("select oneshot from go oneshot where oneshot.codeSite like %:codeSite%" +
            " and oneshot.region like %:region" +
            " and oneshot.typologie like %:typologie%" +
            " and oneshot.cw.etatCw like %:etatCw%")
    Page<OneShot> rechercheOneShot(@Param("codeSite") String codeSite,
                                   @Param("region") String region,
                                   @Param("typologie") String typologie,
                                   @Param("etatCw") String etatCw,
                                   Pageable pageable);
}
