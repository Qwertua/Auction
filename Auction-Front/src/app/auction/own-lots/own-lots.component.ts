import {Component, OnDestroy, OnInit} from '@angular/core';
import {Subscription} from "rxjs";
import { user } from 'src/app/user';
import {AuthService} from "../../authService";
import {HttpOwnerService} from "./http-owner-service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-own-lots',
  templateUrl: './own-lots.component.html',
  styleUrls: ['./own-lots.component.css'],
  providers:[HttpOwnerService]
})
export class OwnLotsComponent implements OnInit{
  user: user | undefined;
  private userSubscription!: Subscription;
  url: string = '';

  constructor(private authService: AuthService, private httpOwnerService: HttpOwnerService) {}

  ngOnInit() {
    this.user = this.authService.getUser();
  }

  delete(lotId: number) {
    this.httpOwnerService.deleteLot(lotId).subscribe(() => {
      this.refreshPage();
    });
  }

  generateUrl(lotId: number) {
    this.httpOwnerService.generateUrl(lotId).subscribe((response: string) => {
      if (response) {
        this.url = response;
      }
    });
  }


  start(lotId: number) {
    this.httpOwnerService.startAuction(lotId).subscribe(() => {
      this.refreshPage();
    });
  }

  stop(lotId: number) {
    this.httpOwnerService.stopAuction(lotId).subscribe(() => {
      this.refreshPage();
    });
  }

  refreshPage() {
    location.reload();
  }
}
