import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Constants } from "../constants/Constants";
import { GroceryProducts } from "../model/GroceryProduct";

@Injectable({ providedIn: 'root' })

export class AddGroceryItemService{

    constructor(private http: HttpClient){}

    addGroceryItem(groceryItem: GroceryProducts){
        return this.http.post(Constants.API_END_POINT+Constants.METHODS.ADD_NEW_ITEM, groceryItem);
    }

}