package com.safarsathi.backend.dao;

import com.safarsathi.backend.entity.Package;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackageDao extends CrudRepository<Package, Integer> {
}
