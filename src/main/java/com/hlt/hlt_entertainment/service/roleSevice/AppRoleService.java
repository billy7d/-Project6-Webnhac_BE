package com.hlt.hlt_entertainment.service.roleSevice;

import com.hlt.hlt_entertainment.model.AppRole;
import com.hlt.hlt_entertainment.model.ERole;
import com.hlt.hlt_entertainment.service.Service;

import java.util.Optional;

public interface AppRoleService extends Service<AppRole> {
    Optional<AppRole> findByName(ERole name);
}
