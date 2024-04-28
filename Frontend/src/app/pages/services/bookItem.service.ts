import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Constants } from "../constants/Constants";

@Injectable({ providedIn: 'root' })

export class BookItemService{

    constructor(private http: HttpClient){}

    bookItem(userId: String){
        return this.http.get(Constants.API_END_POINT+Constants.METHODS.BOOK_ITEM+userId);
    }
}