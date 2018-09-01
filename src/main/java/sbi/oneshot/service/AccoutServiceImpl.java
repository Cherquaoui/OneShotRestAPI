package sbi.oneshot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sbi.oneshot.entities.security.AppRole;
import sbi.oneshot.entities.security.AppUser;
import sbi.oneshot.repositories.security.RoleRepository;
import sbi.oneshot.repositories.security.UserRepository;

@Service
@Transactional
public class AccoutServiceImpl implements AccountService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public AppUser SaveUser(AppUser user) {
        String hashPW = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(hashPW);
        return userRepository.save(user);
    }

    @Override
    public AppRole SaveRole(AppRole role) {
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String user, String role) {
        AppUser User = userRepository.findAppUserByUsername(user);
        AppRole Role = roleRepository.findAppRoleByRole(role);
        User.getRoles().add(Role);

    }

    @Override
    public AppUser findUserByUserName(String name) {
        return userRepository.findAppUserByUsername(name);
    }
}
