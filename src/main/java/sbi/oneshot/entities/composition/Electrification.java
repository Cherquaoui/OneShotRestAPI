package sbi.oneshot.entities.composition;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sbi.oneshot.entities.ElecTrav;

import javax.persistence.*;
import java.sql.Date;

@Entity(name="elecsuivi")
@Getter@Setter
@NoArgsConstructor

public class Electrification {

  @Id
  private String codeSite;
  private String numDossier;
  private String elecEtat;
  private String regie;
  private String elecCommentaires;
  private java.sql.Date depotDemande;
  private java.sql.Date etude;
  private java.sql.Date devis;
  private java.sql.Date payementDevis;
  private java.sql.Date autorisation;
  private java.sql.Date debutTravaux;
  private java.sql.Date finTravaux;
  private java.sql.Date reception;
  private java.sql.Date abonnement;
  private java.sql.Date poseCompteur;
  @OneToOne
  @PrimaryKeyJoinColumn
  private ElecTrav elecTrav;


}
