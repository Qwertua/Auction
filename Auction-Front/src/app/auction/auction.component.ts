import {Component, OnDestroy, OnInit} from '@angular/core';
import {AuthService} from "../authService";
import { user } from '../user';
import {Subscription} from "rxjs";

@Component({
  selector: 'app-auction',
  templateUrl: './auction.component.html',
  styleUrls: ['./auction.component.css']
})
export class AuctionComponent implements OnInit, OnDestroy {
  user: user[] = [];
  private userSubscription!: Subscription;

  constructor(private authService: AuthService) {}

  ngOnInit() {
      this.userSubscription = this.authService.userData$.subscribe((user) => {
        console.log(user);
        this.user = user;
      });
  }

  ngOnDestroy() {
    this.userSubscription.unsubscribe();
  }
}
