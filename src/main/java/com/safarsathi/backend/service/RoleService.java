package com.safarsathi.backend.service;

import com.safarsathi.backend.dao.RoleDao;
import com.safarsathi.backend.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    public Role createNewRole(Role role) {
        return roleDao.save(role);
    }
}
