import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { CartItems } from "../model/CartItems";
import { Constants } from "../constants/Constants";

@Injectable({ providedIn: 'root' })

export class AddToCartService{

    constructor(private http: HttpClient){}

    addToCart(cartItem: CartItems){
        return this.http.put(Constants.API_END_POINT+Constants.METHODS.ADD_TO_CART, cartItem);
    }

}