package sbi.oneshot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sbi.oneshot.entities.security.AppUser;

import java.util.ArrayList;
import java.util.Collection;

@Service
@Primary
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private AccountService accountService;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        AppUser user = accountService.findUserByUserName(s);
        if(user ==null) throw new UsernameNotFoundException(s);

        Collection<GrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(t->authorities.add(new SimpleGrantedAuthority(t.getRole())));
        return new User(user.getUsername(), user.getPassword(),authorities);
    }
}
