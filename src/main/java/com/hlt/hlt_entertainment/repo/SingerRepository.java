package com.hlt.hlt_entertainment.repo;

import com.hlt.hlt_entertainment.model.Singer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SingerRepository extends PagingAndSortingRepository<Singer, Long> {
    Page<Singer> findByNameContains(String name, Pageable pageable);
}
