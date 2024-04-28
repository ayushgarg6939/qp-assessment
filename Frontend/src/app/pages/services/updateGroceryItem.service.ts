import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Constants } from "../constants/Constants";
import { GroceryProducts } from "../model/GroceryProduct";


@Injectable({ providedIn: 'root' })

export class UpdateGroceryItemService{

    constructor(private http: HttpClient){}

    updateGroceryItem(groceryItem: GroceryProducts){
        return this.http.put(Constants.API_END_POINT+Constants.METHODS.UPDATE_GROCERY_ITEM,groceryItem);
    }
}