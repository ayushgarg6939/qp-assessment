import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { GroceryProducts } from "../model/GroceryProduct";
import { Constants } from "../constants/Constants";

@Injectable({ providedIn: 'root' })

export class DeleteGroceryItemService{

    constructor(private http: HttpClient){}

    deleteGroceryItem(groceryItem: GroceryProducts){
        return this.http.post(Constants.API_END_POINT+Constants.METHODS.DELETE_GROCERY_ITEM, groceryItem);
    }
}