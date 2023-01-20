import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddNewPackageComponent } from './add-new-package/add-new-package.component';
import { AdminComponent } from './admin/admin.component';
import { BuyPackageResolverService } from './buy-package-resolver.service';
import { BuyPackageComponent } from './buy-package/buy-package.component';
import { ForbiddenComponent } from './forbidden/forbidden.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { OrderConfirmationComponent } from './order-confirmation/order-confirmation.component';
import { PackageResolverService } from './package-resolver.service';
import { PackageViewDetailsComponent } from './package-view-details/package-view-details.component';
import { ShowOrderConfirmedComponent } from './show-order-confirmed/show-order-confirmed.component';
import { ShowPackageDetailsComponent } from './show-package-details/show-package-details.component';
import { UserComponent } from './user/user.component';
import { AuthGuard } from './_auth/auth.guard';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'admin', component: AdminComponent, canActivate: [AuthGuard], data: { roles: ['Admin'] } },
  { path: 'user', component: UserComponent, canActivate: [AuthGuard], data: { roles: ['User'] } },
  { path: 'login', component: LoginComponent },
  { path: 'forbidden', component: ForbiddenComponent },
  {
    path: 'addnewpackage', component: AddNewPackageComponent, canActivate: [AuthGuard], data: { roles: ['Admin'] },
    resolve: {
      pack: PackageResolverService
    }
  },
  { path: 'showPackageDetails', component: ShowPackageDetailsComponent, canActivate: [AuthGuard], data: { roles: ['Admin'] } },
  {
    path: 'packageviewdetails', component: PackageViewDetailsComponent, resolve: {
      pack: PackageResolverService
    }
  },
  {
    path: 'buyPackage', component: BuyPackageComponent, canActivate: [AuthGuard], data: { roles: ['User'] },
    resolve: {
      packageDetails: BuyPackageResolverService
    }
  },
  {
    path: 'orderConfirmed',
    component : OrderConfirmationComponent,
    canActivate: [AuthGuard], 
    data: { roles: ['User'] }

  },
  { path: 'getAllOrderDetails', component: ShowOrderConfirmedComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
