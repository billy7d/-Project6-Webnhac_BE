package com.hlt.hlt_entertainment.service.user;

import com.hlt.hlt_entertainment.model.AppUser;

public interface AppUserService {
    Iterable<AppUser> findAll();
    AppUser findById(Long id);
    AppUser save(AppUser appUser);
    void delete(Long id);
}
