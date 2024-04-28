import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../../services/authentication.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { OrderHistory } from '../../model/OrderHistory';
import { GetOrderHistoryService } from '../../services/getOrderHistory.service';

@Component({
  selector: 'app-orders',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './orders.component.html',
  styleUrl: './orders.component.css'
})
export class OrdersComponent implements OnInit{


  constructor(private authenticationService: AuthenticationService,
    private router: Router,
    private orderHistory: GetOrderHistoryService){}

  ngOnInit(): void {
    this.getOrderHistory();
  }

  getOrderHistory(){
    if(this.authenticationService.currentUserValue != null){
      this.orderHistory.orderHistory(this.authenticationService.currentUserValue.groceryAppUserId).subscribe((value:any) =>{
        if(value != null){
          this.orderHistoryList = value;
        }
      });
    }
    
  }

    orderHistoryList: OrderHistory[] = [];

}
