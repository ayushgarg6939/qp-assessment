import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { User } from '../../model/User';
import { Router } from '@angular/router';
import { AuthenticationService } from '../../services/authentication.service';
import { AddUserService } from '../../services/addUser.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit{

  private authenticateService :AuthenticationService;

  user: User = {
    groceryAppUserName:'',
    groceryAppUserPassword:'',
    groceryAppUserRole:'',
    groceryAppUserId:''
  }

  newUser: User = {
    groceryAppUserName:'',
    groceryAppUserPassword:'',
    groceryAppUserRole:'User',
    groceryAppUserId:''
  }

  ngOnInit(): void {
    if (typeof history !== 'undefined' && history.pushState) {
      history.pushState(null, '');
    }
  }

  constructor(private router:Router,
    private authenticateServiceConst :AuthenticationService,
    private userSignUpService:AddUserService)
  {
    this.authenticateService = authenticateServiceConst;
  }


  verifyUser(){

    this.authenticateService.getAPIUser(this.user).subscribe((value:any) =>{
      if(value != null){
        if(this.authenticateService.verifyUser(value)){
          window.location.reload();
        }
      }else{
        alert('User not found');
      }

    });
  }

  addUser(){
    if(this.newUser.groceryAppUserName != '' && this.newUser.groceryAppUserPassword != ''){
      this.newUser.groceryAppUserId = this.newUser.groceryAppUserName.concat(this.newUser.groceryAppUserPassword.toString());
      this.userSignUpService.addUser(this.newUser).subscribe((value:any) =>{
        console.log(value);
        if(value.responceStatus == 'Success'){
          alert('User added successfully! You can proceed to login.');
          this.newUser.groceryAppUserName = '';
          this.newUser.groceryAppUserPassword = '';
        }else{
          alert('This user already exists');
        }
      });
    }else{
      alert('Username and Password can not be empty!');
    }
    
  }

}
