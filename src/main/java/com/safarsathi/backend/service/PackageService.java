package com.safarsathi.backend.service;

import com.safarsathi.backend.dao.PackageDao;
import com.safarsathi.backend.entity.Package;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PackageService {
    @Autowired
    private PackageDao packageDao;

    public Package addNewPackage(Package pack){return packageDao.save(pack);}

    public List<Package> getAllPackage(){return (List<Package>) packageDao.findAll();}

    public void deletePackageDetails(Integer packageId){ packageDao.deleteById(packageId);}

    public Package getPackageDetailsById(Integer packageId){ return packageDao.findById(packageId).get();}

    public List<Package>getPackageDetails(boolean isSinglePackageCheckout, Integer packageId){
        if(isSinglePackageCheckout){
            List<Package> list = new ArrayList<>();
            Package pack = packageDao.findById(packageId).get();
            list.add(pack);
            return list;
        }else{

        }
        return new ArrayList<>();
    }
}
