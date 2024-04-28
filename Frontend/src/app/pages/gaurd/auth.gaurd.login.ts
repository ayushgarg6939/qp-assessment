import { Injectable } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';

import { AuthenticationService } from '../services/authentication.service';

@Injectable({ providedIn: 'root' })
export class AuthGuardLogin implements CanActivate {
    constructor(
        private router: Router,
        private authenticationService: AuthenticationService
    ) {}

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const currentUser = this.authenticationService.currentUserValue;
        if (currentUser?.groceryAppUserName != '' && currentUser?.groceryAppUserPassword != '') {
          if(currentUser?.groceryAppUserRole == 'Admin'){
            console.log(currentUser);
            this.router.navigateByUrl('/landing')
            // authorised so return true
            return false;
          }else if(currentUser?.groceryAppUserRole == 'User'){
            console.log(currentUser);
            this.router.navigateByUrl('/product')
            return false;
          }
          return false;
        }
        else {
          return true;
        }
    }
}