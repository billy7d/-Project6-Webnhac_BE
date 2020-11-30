package com.hlt.hlt_entertainment.repo;

import com.hlt.hlt_entertainment.model.Singer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SingerRepository extends JpaRepository<Singer, Long> {

}