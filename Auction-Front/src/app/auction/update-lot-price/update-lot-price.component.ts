import { Component } from '@angular/core';
import {httpServiceUpdate} from "./http-service-update";
import {Lots} from "../table-active-auction/Lots";
import {HttpService} from "../search-by-title/HttpService";

@Component({
  selector: 'app-update-lot-price',
  templateUrl: './update-lot-price.component.html',
  styleUrls: ['./update-lot-price.component.css'],
  providers: [httpServiceUpdate, HttpService]
})
export class UpdateLotPriceComponent {

  lot: Lots[] = [];
  title: string = '';
  price: number = 0;
  error: string = '';

  constructor(private httpService: httpServiceUpdate, private httpServiceTitle: HttpService) {}

  updatePrice() {
    if (!this.title || this.price <= 0) {
      this.error = 'Enter your data';
      return;
    }

    this.httpServiceTitle.getData(this.title).subscribe({
      next: (response) => {
        if (response && Object.keys(response).length > 0) {
          this.lot = response;
        } else {
          this.error = 'Lot not found';
        }
      }
    });

    this.error = '';
      this.httpService.postData(this.title, this.price).subscribe({
        next: (response) => {
          if (response && Object.keys(response).length > 0) {
            this.lot = response;
          }
        },
        error: (error) => {
          this.error = 'Updated price must be > existing price';
        }
      });
      this.refreshPage();
    }

  refreshPage() {
    location.reload();
  }
}
