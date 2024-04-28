import { Inject, Injectable, PLATFORM_ID } from '@angular/core';
import { LoginComponent } from '../website/login/login.component';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { User } from '../model/User';
import { isPlatformBrowser } from '@angular/common';
import { Constants } from '../constants/Constants';

@Injectable({ providedIn: 'root' })
export class AuthenticationService {


    private user: User;
    private platformId: object;

    constructor(@Inject(PLATFORM_ID) platformIdC: object,
    private http: HttpClient){
        this.platformId = platformIdC;
        if (isPlatformBrowser(this.platformId)){
            const storedUser = localStorage.getItem('currentUser');
            if(storedUser != null){           
                this.user = JSON.parse(storedUser);
            }else{
                this.user  = {
                    groceryAppUserName:'',
                    groceryAppUserPassword:'',
                    groceryAppUserRole:'',
                    groceryAppUserId:''
                  }
            }
        }else{
            this.user  = {
                groceryAppUserName:'',
                groceryAppUserPassword:'',
                groceryAppUserRole:'',
                groceryAppUserId:''
              }
        }
    }



    public get currentUserValue(): User|null{
        return this.user;
    }

    getAPIUser(loggedUser: User){
        return this.http.post(Constants.API_END_POINT+Constants.METHODS.LOGIN,loggedUser);
    }

    verifyUser(loggedUser: User):boolean{
        this.user = loggedUser;
        if (isPlatformBrowser(this.platformId)) {
            localStorage.setItem('currentUser', JSON.stringify(this.user));
            return true;
        }  
        else{
            return false;
        }  
      }

     logout() {
         localStorage.removeItem('currentUser');
     }
}