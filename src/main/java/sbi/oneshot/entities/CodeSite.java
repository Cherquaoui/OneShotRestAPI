package sbi.oneshot.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter @Setter
@NoArgsConstructor
public class CodeSite {

    @Id
    private int id;
    private String codeSite;

    public CodeSite(int id, String codeSite) {
        this.id = id;
        this.codeSite = codeSite;
    }
}
