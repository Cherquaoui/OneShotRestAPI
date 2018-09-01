package sbi.oneshot.repositories.security;

import org.springframework.data.jpa.repository.JpaRepository;
import sbi.oneshot.entities.security.AppUser;


public interface UserRepository extends JpaRepository<AppUser,Long> {
    /*AppUser findByUsername(String username);*/
    AppUser findAppUserByUsername(String username);
}
