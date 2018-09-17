package sbi.oneshot.entities;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Getter@Setter
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ElecSuivi {

  @Id
  private String codeSite;
  private String regie;
  private String numDossier;
  @NotNull
  private String elecEtat="00-Att demande_encours";
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

  public ElecSuivi(String codeSite){
    this.codeSite=codeSite;
  }



}
