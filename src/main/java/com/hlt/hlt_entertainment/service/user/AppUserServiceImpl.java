package com.hlt.hlt_entertainment.service.user;

import com.hlt.hlt_entertainment.model.AppUser;
import com.hlt.hlt_entertainment.repo.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AppUserServiceImpl implements AppUserService {
    @Autowired
    private AppUserRepository appUserRepository;
    @Override
    public Iterable<AppUser> findAll() {
        return appUserRepository.findAll();
    }

    @Override
    public AppUser findById(Long id) {
        return appUserRepository.findById(id).orElse(null);
    }

    @Override
    public AppUser save(AppUser appUser) {
        return appUserRepository.save(appUser);
    }

    @Override
    public void delete(Long id) {
        appUserRepository.deleteById(id);
    }
}
