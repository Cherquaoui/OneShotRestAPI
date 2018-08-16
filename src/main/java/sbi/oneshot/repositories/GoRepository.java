package sbi.oneshot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sbi.oneshot.entities.Go;
@RepositoryRestResource
public interface GoRepository extends JpaRepository<Go, String> {
}
