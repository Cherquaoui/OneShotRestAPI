package sbi.oneshot.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter @Setter
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ElecTrav {
  @Id
  private String codeSite;
  private Integer btA;
  private Integer btS;
  private Integer btSRf;
  private Integer btNiche;
  private Integer ok;
}
