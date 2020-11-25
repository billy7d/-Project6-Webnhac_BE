package com.hlt.hlt_entertainment.service.Singer;

import com.hlt.hlt_entertainment.model.Singer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SingerService {
    Page<Singer> findAll(Pageable pageable);
    Singer findBySingerId(Long id);
    Singer save(Singer singer);
    void delete(Long id);
}
