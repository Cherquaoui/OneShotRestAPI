package sbi.oneshot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sbi.oneshot.entities.Cw;

public interface CwRepository extends JpaRepository<Cw,String> {
}
