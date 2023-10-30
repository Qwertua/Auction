import {Component, OnDestroy, OnInit} from '@angular/core';
import {Subscription} from "rxjs";
import { user } from 'src/app/user';
import {AuthService} from "../../authService";
import {HttpOwnerService} from "./http-owner-service";

@Component({
  selector: 'app-own-lots',
  templateUrl: './own-lots.component.html',
  styleUrls: ['./own-lots.component.css'],
  providers:[HttpOwnerService]
})
export class OwnLotsComponent implements OnInit, OnDestroy {
  user: user | undefined;
  private userSubscription!: Subscription;
  url: string = '';

  constructor(private authService: AuthService, private httpOwnerService: HttpOwnerService) {}

  ngOnInit() {
    this.userSubscription = this.authService.userData$.subscribe((user) => {
      console.log(user);
      this.user = user;
    });
  }

  ngOnDestroy() {
    this.userSubscription.unsubscribe();
  }

  delete(lotId: number) {
    this.httpOwnerService.deleteLot(lotId).subscribe(() => {
      // Обработка успешного удаления
      // Можете обновить список лотов после удаления, если это необходимо
    });
  }

  generateUrl(lotId: number) {
    this.httpOwnerService.generateUrl(lotId).subscribe((response: string) => {
      if (response) {
        this.url = response;
        console.log(this.url);
      }
    });
  }


  start(lotId: number) {
    this.httpOwnerService.startAuction(lotId).subscribe(() => {
      // Обработка успешного запуска аукциона
    });
  }

  stop(lotId: number) {
    this.httpOwnerService.stopAuction(lotId).subscribe(() => {
      // Обработка успешной остановки аукциона
    });
  }
}
