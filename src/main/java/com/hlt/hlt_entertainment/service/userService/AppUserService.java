package com.hlt.hlt_entertainment.service.userService;

import com.hlt.hlt_entertainment.model.AppUser;
import com.hlt.hlt_entertainment.service.Service;

import java.util.Optional;

public interface AppUserService extends Service<AppUser> {
    Optional<AppUser> findByUserName(String username);
    Boolean existsByUserName(String username);
}
