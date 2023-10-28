import { Component } from '@angular/core';
import {Lots} from "./Lots";
import {HttpService} from "./HttpService";

@Component({
  selector: 'app-table-active-auction',
  templateUrl: './table-active-auction.component.html',
  styleUrls: ['./table-active-auction.component.css']
})
export class TableActiveAuctionComponent {

  lots: Lots[] = [];

  constructor(private httpService: HttpService) { }

  ngOnInit(): void {
    this.httpService.getActiveLots().subscribe((data: Lots[]) => {
      this.lots = data;
    });
  }
}
