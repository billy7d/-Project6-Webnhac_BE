package com.hlt.hlt_entertainment.repo;

import com.hlt.hlt_entertainment.model.AppRole;
import com.hlt.hlt_entertainment.model.ERole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppRoleRepository extends JpaRepository<AppRole, Long> {
    Optional<AppRole> findByName(ERole name);
}
