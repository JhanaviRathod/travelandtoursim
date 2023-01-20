package com.safarsathi.backend.controller;

import com.safarsathi.backend.entity.ImageModel;
import com.safarsathi.backend.entity.Package;
import com.safarsathi.backend.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class PackageController {
    @Autowired
    private PackageService packageService;
    @PreAuthorize("hasRole('Admin')")
    @PostMapping(value = {"/addNewPackage"}, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public Package addNewPackage(@RequestPart("pack") Package pack,
                                 @RequestPart("imageFile")MultipartFile[] file){
        //return packageService.addNewPackage(pack);
        try{
            Set<ImageModel> images = uploadImage(file);
            pack.setPackageImage(images);
           return packageService.addNewPackage(pack);

        }catch (Exception e ){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Set<ImageModel> uploadImage(MultipartFile[] multipartFiles) throws IOException {
        Set<ImageModel> imageModels = new HashSet<>();
        for(MultipartFile file : multipartFiles){
            ImageModel imageModel = new ImageModel(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getBytes()
            );
            imageModels.add(imageModel);
        }
        return imageModels;
    }

    @GetMapping({"/getAllPackage"})
    public List<Package> getAllPackage(){
        return packageService.getAllPackage();
    }

    @GetMapping({"/getPackageDetailsById/{packageId}"})
    public Package getPackageDetailsById( @PathVariable("packageId")Integer packageId){
        return packageService.getPackageDetailsById(packageId);
    }

    @DeleteMapping({"/deletePackageDetails/{packageId}"})
    public void deletePackageDetails(@PathVariable("packageId") Integer packageId){
        packageService.deletePackageDetails(packageId);
    }
    @PreAuthorize("hasRole('User')")
    @GetMapping({"/getPackageDetails/{isSinglePackageCheckout}/{packageId}"})
    public List<Package>  getPackageDetails(@PathVariable(name = "isSinglePackageCheckout") boolean isSinglePackageCheckout,
                                  @PathVariable(name = "packageId") Integer packageId){
        return packageService.getPackageDetails(isSinglePackageCheckout, packageId);
    }
}
