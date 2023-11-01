import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Lots} from "../../user";

@Injectable()
export class LotService {
  private url = 'http://localhost:8080/api';

  constructor(private http: HttpClient) {}

  addLot(userId: number, lot: Lots): Observable<Lots> {
    const url = `${this.url}/lots/${userId}`;
    return this.http.post<Lots>(url, lot);
  }
}
