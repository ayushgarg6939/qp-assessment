import { Routes } from '@angular/router';
import { LoginComponent } from './pages/website/login/login.component';
import { LandingComponent } from './pages/website/landing/landing.component';
import { AuthGuard } from './pages/gaurd/auth.gaurd';
import { ProductPageComponent } from './pages/website/product-page/product-page.component';
import { CartPageComponent } from './pages/website/cart-page/cart-page.component';
import { OrdersComponent } from './pages/website/orders/orders.component';
import { AuthGuardUser } from './pages/gaurd/auth.gaurd.user';
import { AuthGuardLogin } from './pages/gaurd/auth.gaurd.login';
import { CheckoutComponent } from './pages/website/checkout/checkout.component';

export const routes: Routes = [

    {
        path:'',
        redirectTo:'landing',
        pathMatch:'full'
    },
    {
        path:'login',
        component:LoginComponent,
        canActivate: [AuthGuardLogin]
    },{
        path:'userCheck',
        component:CheckoutComponent
    },
    {
        path:'product',
        component:ProductPageComponent,
        canActivate: [AuthGuardUser]
    },
    {
        path:'cart',
        component:CartPageComponent
    },
    {
        path:'order',
        component:OrdersComponent
    },
    {
        path:'landing',
        component:LandingComponent,
        canActivate:[AuthGuard]
    }
];
