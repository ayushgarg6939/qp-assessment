import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { CartItems } from "../model/CartItems";
import { Constants } from "../constants/Constants";

@Injectable({ providedIn: 'root' })

export class RemoveCartService{

    constructor(private http: HttpClient){}

    removeFromCart(cartItem:CartItems){
        return this.http.post(Constants.API_END_POINT+Constants.METHODS.REMOVE_FROM_CART, cartItem);
    }

}