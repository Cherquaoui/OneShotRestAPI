package sbi.oneshot.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter@Setter
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Cw implements Serializable {
  @Id
  private String codeSite;
  private String commentairesCw;
  private String etatCw;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "equipe_Cw")

  private Equipe equipeCw;
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
