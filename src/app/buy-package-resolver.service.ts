import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve, RouterStateSnapshot } from '@angular/router';
import { Observable } from 'rxjs';
import { Package } from './_model/package.model';
import { PackageService } from './_services/package.service';

@Injectable({
  providedIn: 'root'
})
export class BuyPackageResolverService implements Resolve<Package[]> {

  constructor(private packageService : PackageService) { }
  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Package[] | Observable<Package[]> | Promise<Package[]> {
    const id = route.paramMap.get("id");
    const isSinglePackageCheckout = route.paramMap.get("isSinglePackageCheckout");
    return this.packageService.getPackageDetails(isSinglePackageCheckout, id);
  }

  
}
