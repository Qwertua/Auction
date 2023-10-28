import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { TableActiveAuctionComponent } from './table-active-auction/table-active-auction.component';
import {HttpClientModule} from "@angular/common/http";
import {HttpService} from "./table-active-auction/HttpService";
import { SearchByTitleComponent } from './search-by-title/search-by-title.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { UpdateLotPriceComponent } from './update-lot-price/update-lot-price.component';

@NgModule({
  declarations: [
    AppComponent,
    TableActiveAuctionComponent,
    SearchByTitleComponent,
    UpdateLotPriceComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
  ],
  providers: [HttpService],
  bootstrap: [AppComponent]
})
export class AppModule{ }
