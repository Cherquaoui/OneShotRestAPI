package sbi.oneshot.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import sbi.oneshot.entities.Equipe;

@RestResource
public interface EquipeRepository extends JpaRepository<Equipe, Integer> {
}
