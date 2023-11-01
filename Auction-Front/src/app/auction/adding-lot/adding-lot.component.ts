import { Component } from '@angular/core';
import {LotService} from "./LotService";
import {Lots} from "../../user";
import {AuthService} from "../../authService";

@Component({
  selector: 'app-adding-lot',
  templateUrl: './adding-lot.component.html',
  styleUrls: ['./adding-lot.component.css'],
  providers: [LotService]
})
export class AddingLotComponent {
  lot: Lots = {
    id: null,
    title: '',
    description: '',
    startTime: '',
    endTime: '',
    startingPrice: {
      id: null,
      price: 0
    }
  };


  constructor(private lotService: LotService, private authService: AuthService) {  }

  addLot() {
    const user = this.authService.getUser();
    if (user) {
      const userId = user.id;
      console.log(this.lot);
      this.lotService.addLot(userId, this.lot).subscribe((addedLot) => {
        console.log('Lot added:', addedLot);
        this.lot = {
          id: null,
          title: '',
          description: '',
          startTime: '',
          endTime: '',
          startingPrice: {
            id: null,
            price: 0
          }
        };
      });
    }
  }
}
