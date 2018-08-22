package sbi.oneshot.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter@Setter
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Cw {
  @Id
  private String codeSite;
  private String equipeCw;
  private String commentairesCw;
  private String etatCw;
  private java.sql.Date ouverture;
  private java.sql.Date fouilles;
  private java.sql.Date coulage;
  private java.sql.Date montage;
  private java.sql.Date finCw;
  private java.sql.Date blocage;
  private java.sql.Date deblocage;




}
