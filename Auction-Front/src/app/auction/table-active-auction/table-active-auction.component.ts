import { Component } from '@angular/core';
import {Lots} from "./Lots";
import {HttpService} from "./HttpService";
import {Router} from "@angular/router";

@Component({
  selector: 'app-table-active-auction',
  templateUrl: './table-active-auction.component.html',
  styleUrls: ['./table-active-auction.component.css']
})
export class TableActiveAuctionComponent {

  lots: Lots[] = [];

  constructor(private httpService: HttpService, private router: Router) { }

  ngOnInit(): void {
    this.httpService.getActiveLots().subscribe((data: Lots[]) => {
      this.lots = data;
    });
  }

  logout() {
    this.router.navigate(['/login'])
  }
}
