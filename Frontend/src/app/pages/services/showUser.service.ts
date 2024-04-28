import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { CartItems } from "../model/CartItems";
import { Constants } from "../constants/Constants";
import { User } from "../model/User";

@Injectable({ providedIn: 'root' })

export class ShowUsersService{

    constructor(private http: HttpClient){}

    viewUsers(){
        return this.http.get(Constants.API_END_POINT+Constants.METHODS.VIEW_USERS);
    }

    updateUser(user: User){
        return this.http.put(Constants.API_END_POINT+Constants.METHODS.UPDATE_USER_ROLE, user);
    }

}