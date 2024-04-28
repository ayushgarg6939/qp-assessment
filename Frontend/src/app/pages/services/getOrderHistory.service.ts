import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Constants } from "../constants/Constants";

@Injectable({ providedIn: 'root' })

export class GetOrderHistoryService{

    constructor(private http: HttpClient){}

    orderHistory(userId: String){
        return this.http.get(Constants.API_END_POINT+Constants.METHODS.ORDER_HISTORY+userId);
    }
}