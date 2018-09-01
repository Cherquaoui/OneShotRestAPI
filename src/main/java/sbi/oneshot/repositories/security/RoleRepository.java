package sbi.oneshot.repositories.security;

import org.springframework.data.jpa.repository.JpaRepository;
import sbi.oneshot.entities.security.AppRole;

public interface RoleRepository extends JpaRepository<AppRole, Long> {
    AppRole findAppRoleByRole(String role);
}
