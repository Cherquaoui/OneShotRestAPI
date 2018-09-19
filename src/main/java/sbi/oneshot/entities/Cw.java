package sbi.oneshot.entities;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import sbi.oneshot.repositories.EquipeRepository;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Getter@Setter
@NoArgsConstructor

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Cw implements Serializable {





  @Id
  private String codeSite;
  private String commentairesCw;
  @NotNull
  private String etatCw="00-Att ouverture_encours";
  @NotNull
  @ManyToOne
  @JoinColumn(name = "equipe_Cw")
  private Equipe equipeCw = new Equipe(1);



  private java.sql.Date ouverture;
  private java.sql.Date fouilles;
  private java.sql.Date coulage;
  private java.sql.Date montage;
  private java.sql.Date finCw;
  private java.sql.Date blocage;
  private java.sql.Date deblocage;

  public Cw(String codeSite){
    this.codeSite=codeSite;
  }




}
