package com.hlt.hlt_entertainment.service.userService;

import com.hlt.hlt_entertainment.model.AppUser;
import com.hlt.hlt_entertainment.repo.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AppUserServiceImp implements AppUserService, UserDetailsService {

    @Autowired
    private AppUserRepository appUserRepository;
    @Override
    public Iterable<AppUser> findAll() {
        return appUserRepository.findAll();
    }

    @Override
    public AppUser findById(Long id) {
        return appUserRepository.findById(id).get();
    }

    @Override
    public void save(AppUser model) {
        appUserRepository.save(model);
    }

    @Override
    public void remove(Long id) {
        appUserRepository.deleteById(id);
    }

    @Override
    public Optional<AppUser> findByUserName(String username) {
        return appUserRepository.findByUserName(username);
    }

    @Override
    public Boolean existsByUserName(String username) {
        return appUserRepository.existsByUserName(username);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = appUserRepository.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        return UserDetailsImpl.build(user);
    }
}
