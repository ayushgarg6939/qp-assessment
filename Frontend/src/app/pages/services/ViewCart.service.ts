import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Constants } from "../constants/Constants";

@Injectable({ providedIn: 'root' })

export class ViewCartService{

    constructor(private http: HttpClient){}

    viewCart(userId: String){
        return this.http.get(Constants.API_END_POINT+Constants.METHODS.VIEW_CART+userId);
    }

}