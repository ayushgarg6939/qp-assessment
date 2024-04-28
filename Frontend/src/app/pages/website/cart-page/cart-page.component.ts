import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../../services/authentication.service';
import { Router, NavigationEnd } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { GroceryProducts } from '../../model/GroceryProduct';
import { CartItems } from '../../model/CartItems';
import { ViewCartService } from '../../services/ViewCart.service';
import { filter } from 'rxjs';
import { RemoveCartService } from '../../services/removeFromCart.service';
import { BookItemService } from '../../services/bookItem.service';

@Component({
  selector: 'app-cart-page',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './cart-page.component.html',
  styleUrl: './cart-page.component.css'
})
export class CartPageComponent implements OnInit{

  constructor(private authenticationService: AuthenticationService,
    private router: Router,
    private viewMyCart:ViewCartService,
    private removeCartItem: RemoveCartService,
    private bookItem: BookItemService
  ){}

  groceryItemsList: GroceryProducts[] = [];
  cartItem: CartItems[] = [];

  cartIndex: number = 0;
  ngOnInit(): void{
    this.subscribeToRouterEvents();
    this.viewAllCartItems();
  }

  subscribeToRouterEvents() {
    this.router.events.pipe(
      filter((event) => event instanceof NavigationEnd)
    ).subscribe(() => {
      this.viewAllCartItems();
    });
  }

  viewAllCartItems(){
    
    if (this.authenticationService.currentUserValue != null) {
      this.viewMyCart.viewCart(this.authenticationService.currentUserValue.groceryAppUserId).subscribe((value: any) => {
          this.cartItem = value;
          console.log(this.cartItem);
      });
    }  
  }

  removeFromCart(product:CartItems){
    this.removeCartItem.removeFromCart(product).subscribe((value:any) =>{
      if(value.responceStatus == 'Success'){
        alert('Item Removed from Cart!')
        this.viewAllCartItems();
      }
    });
  }

  placeOrder(){
    if (this.authenticationService.currentUserValue != null){
      this.bookItem.bookItem(this.authenticationService.currentUserValue.groceryAppUserId).subscribe((value:any) =>{
            if(value.responceStatus != 'Failed'){
              alert('Your order has been placed!\nYour total bill is '+value.responceStatus);
              console.log(value.responceStatus);
              this.viewAllCartItems();
            }    
      });
    }
  }
}
