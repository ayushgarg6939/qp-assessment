import { Injectable } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';

import { AuthenticationService } from '../services/authentication.service';

@Injectable({ providedIn: 'root' })
export class AuthGuardUser implements CanActivate {
    constructor(
        private router: Router,
        private authenticationService: AuthenticationService
    ) {}

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const currentUser = this.authenticationService.currentUserValue;
        if (currentUser?.groceryAppUserName != '' && currentUser?.groceryAppUserPassword != '') {
          if(currentUser?.groceryAppUserRole == 'Admin'){
            this.router.navigateByUrl('/landing')
            return false;
          }else if(currentUser?.groceryAppUserRole == 'User'){
            console.log(currentUser);
            return true;
          }
          return false;
        }
        else {
          // not logged in so redirect to login page with the return url
          this.router.navigate(['/login']);
          return false;
        }
    }
}