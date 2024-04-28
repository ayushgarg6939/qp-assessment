import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Constants } from "../constants/Constants";


@Injectable({ providedIn: 'root' })

export class ViewAllItemsService{

    constructor(private http: HttpClient){}

    getAllProducts(){
        return this.http.get<any>(Constants.API_END_POINT+Constants.METHODS.GET_ALL_ITEMS);
    }
}