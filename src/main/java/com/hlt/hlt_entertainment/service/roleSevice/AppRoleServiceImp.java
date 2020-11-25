package com.hlt.hlt_entertainment.service.roleSevice;

import com.hlt.hlt_entertainment.model.AppRole;
import com.hlt.hlt_entertainment.model.ERole;
import com.hlt.hlt_entertainment.repo.AppRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppRoleServiceImp implements AppRoleService {
    @Autowired
    private AppRoleRepository appRoleRepository;

    @Override
    public Optional<AppRole> findByName(ERole name) {
        return appRoleRepository.findByName(name);
    }

    @Override
    public Iterable<AppRole> findAll() {
        return appRoleRepository.findAll();
    }

    @Override
    public AppRole findById(Long id) {
        return appRoleRepository.findById(id).get();
    }

    @Override
    public void save(AppRole model) {
        appRoleRepository.save(model);
    }

    @Override
    public void remove(Long id) {
        appRoleRepository.deleteById(id);
    }
}
