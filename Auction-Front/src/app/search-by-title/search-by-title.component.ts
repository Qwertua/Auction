import { Component } from '@angular/core';
import {HttpService} from "./HttpService";
import {lotsTitle} from "./lotsTitle";

@Component({
  selector: 'app-search-by-title',
  templateUrl: './search-by-title.component.html',
  styleUrls: ['./search-by-title.component.css'],
  providers: [HttpService]
})
export class SearchByTitleComponent {

  title: string = '';
  lot: lotsTitle[] | undefined;
  error: string = '';

  constructor(private httpService: HttpService) {}

  getData() {
    if (!this.title) {
      this.error = 'Enter lot title pls';
    } else {
      this.error = '';

      this.httpService.getData(this.title).subscribe({
        next: (response) => {
          if (response && Object.keys(response).length > 0) {
            this.lot = response;
          } else {
            this.error = 'Lot not found';
          }
        },
        error: (error) => {
          this.error = 'Bad request';
        }
      });
    }
  }
}
