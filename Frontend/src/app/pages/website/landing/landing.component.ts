import { Component, OnInit } from '@angular/core';
import { CommonModule, Location } from '@angular/common';
import { GroceryProducts } from '../../model/GroceryProduct';
import { FormsModule } from '@angular/forms';
import { ViewAllItemsService } from '../../services/viewAllItems.service';
import { __values } from 'tslib';
import { AddGroceryItemService } from '../../services/addGroceryItem.service';
import { UpdateGroceryItemService } from '../../services/updateGroceryItem.service';
import { DeleteGroceryItemService } from '../../services/deleteGroceryItem.service';
import { AuthenticationService } from '../../services/authentication.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-landing',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './landing.component.html',
  styleUrl: './landing.component.css'
})
export class LandingComponent implements OnInit{
  isSidePannelVisible: boolean = true;
  isUpdateButtonVisible:boolean = false;
  isConfirmButtonVisible:boolean = true;
  
  groceryProducts: GroceryProducts = {
    groceryItemName : '',
    groceryItemInventorySize : 0,
    groceryItemPrize : 0,
    imgUrl : ''
  }

  groceryItemsList: GroceryProducts[] = [];

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

  constructor(private viewAllProducts:ViewAllItemsService,
    private addGroceryItem: AddGroceryItemService,
    private updateGroceryItem: UpdateGroceryItemService,
    private deleteGroceryItem: DeleteGroceryItemService,
    private authenticationService: AuthenticationService,
    private router: Router,
    private location: Location
  ){}

  logout(){
    const confirmLogout = confirm('Are you sure you want to logout ?');
    if(confirmLogout){
      this.authenticationService.logout();
      window.location.reload();
    }
  }

  closeItemGenerator(){
    this.isSidePannelVisible = false;
  }

  openItemGenerator(){
    this.isSidePannelVisible = true;
    this.isConfirmButtonVisible = true;
    this.isUpdateButtonVisible = false;
    this.groceryProducts.groceryItemName = '';
    this.groceryProducts.groceryItemInventorySize = 0;
    this.groceryProducts.groceryItemPrize = 0;
    this.groceryProducts.imgUrl = '';
  }

  checkUser(){
    this.router.navigateByUrl('/userCheck');
  }

  deleteItem(product:GroceryProducts){
    const isDelete = confirm("Are you sure you want to delete this item ?")
    if(isDelete){
      this.deleteGroceryItem.deleteGroceryItem(product).subscribe((value:any) =>{
        if(value.responceStatus == 'Success'){
          this.getAllProducts();
          alert('Item deleted successfully!');
        }else{
          alert('Unable to delete item!');
        }
      });
    }
  }

  confirmUpdate(){
    this.isUpdateButtonVisible = false;
    this.updateGroceryItem.updateGroceryItem(this.groceryProducts).subscribe((value:any) =>{
      console.log(value);
      if(value.responceStatus == 'Success'){
        this.getAllProducts();
        alert('Item updated successfully!');
      }else{
        alert('Unable to update item!');
      }
    });
  }

  saveItem(){
    this.addGroceryItem.addGroceryItem(this.groceryProducts).subscribe((value:any) =>{
      if(value.responceStatus == 'Success'){
        this.getAllProducts();
        alert('Item added successfully!');
      }else{
        alert('Unable to add item!');
      }
    });
  }

  updateItem(product:GroceryProducts){
    this.isSidePannelVisible = true;
    this.isUpdateButtonVisible = true;
    this.isConfirmButtonVisible = false;
    this.groceryProducts.groceryItemName = product.groceryItemName;
    this.groceryProducts.groceryItemInventorySize = product.groceryItemInventorySize;
    this.groceryProducts.groceryItemPrize = product.groceryItemPrize;
    this.groceryProducts.imgUrl = product.imgUrl;
  }

}
