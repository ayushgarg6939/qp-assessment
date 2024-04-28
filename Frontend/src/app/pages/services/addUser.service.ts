import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Constants } from "../constants/Constants";
import { User } from "../model/User";

@Injectable({ providedIn: 'root' })

export class AddUserService{

    constructor(private http: HttpClient){}

    addUser(user: User){
        return this.http.post(Constants.API_END_POINT+Constants.METHODS.SIGN_UP, user);
    }

}