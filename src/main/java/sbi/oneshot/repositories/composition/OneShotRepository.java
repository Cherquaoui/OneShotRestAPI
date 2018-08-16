package sbi.oneshot.repositories.composition;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sbi.oneshot.entities.composition.OneShot;

public interface OneShotRepository extends JpaRepository<OneShot,String> {
}
