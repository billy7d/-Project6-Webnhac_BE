package com.hlt.hlt_entertainment.repo;

import com.hlt.hlt_entertainment.model.AppUser;
import org.springframework.data.repository.CrudRepository;

public interface AppUserRepository extends CrudRepository<AppUser, Long> {
}
