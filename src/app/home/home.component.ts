import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { map } from 'rxjs';
import { ImageProcessingService } from '../image-processing.service';
import { Package } from '../_model/package.model';
import { PackageService } from '../_services/package.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  
  
  packageDetails : Package[] = [];
  ngOnInit(): void {
    this.getAllPackage();
  }
  constructor(private packageService : PackageService, private imageProcessingService : ImageProcessingService, private router : Router ){}

  public getAllPackage(){
    this.packageService.getAllPackage().subscribe(   
      (resp: Package[]) => {
        console.log(resp);
        this.packageDetails = resp;
        
      }, (error : HttpErrorResponse) =>{
        console.log(error);
      }
     );
  }

  showPackageDetails(packageId : number){
    this.router.navigate(['/packageviewdetails', {packageId : packageId}]);
  }
}
