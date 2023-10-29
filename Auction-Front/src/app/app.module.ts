import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { TableActiveAuctionComponent } from './auction/table-active-auction/table-active-auction.component';
import {HttpClientModule} from "@angular/common/http";
import {HttpService} from "./auction/table-active-auction/HttpService";
import { SearchByTitleComponent } from './auction/search-by-title/search-by-title.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { UpdateLotPriceComponent } from './auction/update-lot-price/update-lot-price.component';
import { LoginComponent } from './login/login.component';
import {RouterModule} from "@angular/router";
import { RegComponent } from './reg/reg.component';
import { AuctionComponent } from './auction/auction.component';
import {AuthService} from "./authService";


@NgModule({
  declarations: [
    AppComponent,
    TableActiveAuctionComponent,
    SearchByTitleComponent,
    UpdateLotPriceComponent,
    LoginComponent,
    RegComponent,
    AuctionComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    RouterModule.forRoot([
      { path: 'login', component: LoginComponent },
      { path: 'registration', component: RegComponent },
      { path: 'auction', component: AuctionComponent},
    ])
  ],
  providers: [HttpService, AuthService],
  bootstrap: [AppComponent]
})
export class AppModule{ }
