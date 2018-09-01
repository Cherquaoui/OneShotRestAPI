package sbi.oneshot.service;

import org.springframework.stereotype.Service;
import sbi.oneshot.entities.security.AppRole;
import sbi.oneshot.entities.security.AppUser;

@Service
public interface AccountService {
    AppUser SaveUser(AppUser user);
    AppRole SaveRole(AppRole role);
    void addRoleToUser(String user, String role);
    public AppUser findUserByUserName(String name);
}
