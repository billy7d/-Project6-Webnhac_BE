package com.hlt.hlt_entertainment.repo;

import com.hlt.hlt_entertainment.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
}
