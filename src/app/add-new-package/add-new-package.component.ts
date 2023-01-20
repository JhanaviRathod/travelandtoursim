import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { DomSanitizer } from '@angular/platform-browser';
import { ActivatedRoute } from '@angular/router';
import { FileHandle } from '../_model/file-handle-model';
import { Package } from '../_model/package.model';
import { PackageService } from '../_services/package.service';

@Component({
  selector: 'app-add-new-package',
  templateUrl: './add-new-package.component.html',
  styleUrls: ['./add-new-package.component.css']
})
export class AddNewPackageComponent implements OnInit{
  pack : Package ={
    packageId : null,
    packageName : "",
    description : "",
    packageActualPrice : 0,
    packageDiscountedPrice : 0,
    packageImages : []

  }
  constructor(private packageService : PackageService, private sanitizer : DomSanitizer, private acivatedRoute : ActivatedRoute){}
  ngOnInit(): void {
    this.pack = this.acivatedRoute.snapshot.data['pack'];
  }
  addPackage(packageForm: NgForm){
    const packageFormData = this.prepareFormData(this.pack);
    this.packageService.addPackage(packageFormData).subscribe(
      (response : Package) =>{
        packageForm.reset();
        
        alert("Package added successfully");

      },
      (error : HttpErrorResponse) =>{
        console.log(error);
      }
    );
  }
  prepareFormData(pack : Package): FormData{
    const formData = new FormData()
    formData.append(
      'pack',
      new Blob([JSON.stringify(pack)], {type : 'application/json'})
    )
    for(var i = 0; i < pack.packageImages.length; i++){

      formData.append(
        'imageFile',
        pack.packageImages[i].file,
        pack.packageImages[i].file.name
      )
    }
    return formData;
  }
 onFileSelected(event : any){
  if(event.target.files){
    const file = event.target.files[0];

    const fileHandle : FileHandle = {
      file: file,
      url:  this.sanitizer.bypassSecurityTrustUrl(
        window.URL.createObjectURL(file)
      )
    }
    this.pack.packageImages.push(fileHandle);
  }
  }

  removeImages(i: number){
    this.pack.packageImages.splice(i, 1);
  }
}
