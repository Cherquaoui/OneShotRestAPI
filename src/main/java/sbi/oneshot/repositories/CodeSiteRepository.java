package sbi.oneshot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sbi.oneshot.entities.CodeSite;

public interface CodeSiteRepository extends JpaRepository<CodeSite, Integer> {
}
