import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../../services/authentication.service';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { GroceryProducts } from '../../model/GroceryProduct';
import { ViewAllItemsService } from '../../services/viewAllItems.service';
import { CartItems } from '../../model/CartItems';
import { AddToCartService } from '../../services/addToCart.service';


@Component({
  selector: 'app-product-page',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './product-page.component.html',
  styleUrl: './product-page.component.css'
})
export class ProductPageComponent implements OnInit{
  constructor(private authenticationService: AuthenticationService,
    private router: Router,
    private viewAllProducts:ViewAllItemsService,
    private authService: AuthenticationService,
    private addToCartService: AddToCartService,){

  }

  groceryItemsList: GroceryProducts[] = [];
  cartItem: CartItems = {
    groceryUserId:'',
    groceryItemName:'',
    groceryItemQuantity:0,
    groceryItemUrl:'',
    groceryItemPrice:0
  }

  ngOnInit(): void {
    if (typeof history !== 'undefined' && history.pushState) {
      history.pushState(null, '');
    }
    this.getAllProducts();
  }

  getAllProducts(){
    this.viewAllProducts.getAllProducts().subscribe(value =>{
      this.groceryItemsList = value;
      console.log(this.groceryItemsList);
    });
  }

  logout(){
    const confirmLogout = confirm('Are you sure you want to logout ?');
    if(confirmLogout){
      this.authenticationService.logout();
      window.location.reload();
    }
  }

  addToCart(quantity: String, itemName: String, imgUrl:String, groceryItemPrize:number){
    if(this.authService.currentUserValue != null){
      if(quantity == ''){
        alert("Please enter atleast 1 quantity");
      }else{
        this.cartItem.groceryItemName=itemName;
        this.cartItem.groceryItemQuantity=Number(quantity);
        this.cartItem.groceryUserId=this.authService.currentUserValue.groceryAppUserId;
        this.cartItem.groceryItemUrl=imgUrl;
        this.cartItem.groceryItemPrice=groceryItemPrize;
        this.addToCartService.addToCart(this.cartItem).subscribe((value:any) =>{
          if(value.responceStatus == 'Success'){
            alert('Item added to cart');
          }else{
            alert('Unable to add the item');
          }
        });
      }
      
    }
  }

  openCart(){
    this.router.navigateByUrl('/cart');
  }

  openOrders(){
    this.router.navigateByUrl('/order');
  }
}
