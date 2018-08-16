package sbi.oneshot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sbi.oneshot.entities.ElecSuivi;

public interface ElecSuiviRepository extends JpaRepository<ElecSuivi, String> {
}
