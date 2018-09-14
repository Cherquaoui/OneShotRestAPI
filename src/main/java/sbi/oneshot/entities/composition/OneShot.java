package sbi.oneshot.entities.composition;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sbi.oneshot.entities.Cw;
import sbi.oneshot.entities.ElecSuivi;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name = "go")
@Getter @Setter
@NoArgsConstructor
public class OneShot {

  @Id
  private String codeSite;
  private Double latitude;
  private java.sql.Date dateGo;
  private Double longitude;
  private String region;
  private String typologie;
  private Long hauteur;
  @OneToOne
  @PrimaryKeyJoinColumn
  private Cw cw;
  @OneToOne
  @PrimaryKeyJoinColumn
  private Electrification elec;



}
