import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { OrderDetails } from '../_model/order-details-model';
import { Package } from '../_model/package.model';
import { PackageService } from '../_services/package.service';

@Component({
  selector: 'app-buy-package',
  templateUrl: './buy-package.component.html',
  styleUrls: ['./buy-package.component.css']
})
export class BuyPackageComponent implements OnInit {
  packageDetails : Package[] = [];
  orderDetails : OrderDetails = {
    fullname: '',
    fullAddress: '',
    contactNumber: '',
    alternatecontactNumber: '',
    orderPackageQuantityList: []
  }
  constructor(private acivateRoute : ActivatedRoute, private packageService : PackageService, private router : Router){}
  ngOnInit(): void {
    this.packageDetails = this.acivateRoute.snapshot.data['packageDetails'];

    this.packageDetails.forEach(
      x=> this.orderDetails.orderPackageQuantityList.push(
        {packageId : x.packageId, quantity : 1}
      )
    )
    console.log(this.orderDetails);
    console.log(this.packageDetails);
  }
  placeOrder(orderForm: NgForm){
    this.packageService.placeOrder(this.orderDetails).subscribe(
      (resp) =>{
        console.log(resp);
        orderForm.reset();
        this.router.navigate(['/orderConfirmed'])
      },
      (err)=>{
        console.log(err);
      }
    )
  }
  getQuantityForPackage(packageId : any){
    const fiteredPackage = this.orderDetails.orderPackageQuantityList.filter(
      (packageQuantity) => packageQuantity.packageId === packageId
    );
    return fiteredPackage[0].quantity;
  }

  getCalculatedTotal(packageId : any, packageDiscountedPrice : any){
    const fiteredPackage = this.orderDetails.orderPackageQuantityList.filter(
      (packageQuantity) => packageQuantity.packageId === packageId
    );
      return fiteredPackage[0].quantity * packageDiscountedPrice;
  }

  onQuantityChanged(quantity : any, packageId : any){
    this.orderDetails.orderPackageQuantityList.filter(
      (orderPackage) => orderPackage.packageId === packageId
    )[0].quantity = quantity;
  }
  
}
