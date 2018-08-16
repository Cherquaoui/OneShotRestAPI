package sbi.oneshot.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.ResourceSupport;
import javax.persistence.*;
import java.io.Serializable;


@Entity
@Embeddable
@Getter @Setter
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Go extends ResourceSupport implements Serializable {

  @Id
  private String codeSite;

  private Double latitude;
  private java.sql.Date dateGo;
  private Double longitude;
  private String region;
  private String typologie;
  private Long hauteur;




}
