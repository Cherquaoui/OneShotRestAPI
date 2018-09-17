package sbi.oneshot.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Equipe implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    private String nom;
    private Integer cw;
    private Integer elec;
    private Integer radio;
    private Integer trans;

    public Equipe(int id){
        this.id = id;
    }





}
