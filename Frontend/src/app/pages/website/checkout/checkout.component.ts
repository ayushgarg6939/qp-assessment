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
import { User } from '../../model/User';
import { ShowUsersService } from '../../services/showUser.service';

@Component({
  selector: 'app-checkout',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './checkout.component.html',
  styleUrl: './checkout.component.css'
})
export class CheckoutComponent implements OnInit{

  constructor(private users: ShowUsersService){}

  ngOnInit(): void {
      this.populateUserList();
  }
  
  populateUserList(){
    this.users.viewUsers().subscribe((value:any) =>{
      if(value != null){
        this.userList = value;
      }
    });
  }

  makeAdmin(user: User){
    user.groceryAppUserRole = 'Admin';
    this.users.updateUser(user).subscribe((value:any) =>{
      if(value.responceStatus == 'Success'){
        alert('User converted to Admin!');
        this.populateUserList();
      }
    });
  }

  userList: User[] = [];
}
