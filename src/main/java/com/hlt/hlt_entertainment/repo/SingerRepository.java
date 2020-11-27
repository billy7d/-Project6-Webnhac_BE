package com.hlt.hlt_entertainment.repo;

import com.hlt.hlt_entertainment.model.Singer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SingerRepository extends JpaRepository<Singer, Long> {
}
