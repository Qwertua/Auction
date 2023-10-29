import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable()
export class httpServiceUpdate{

  constructor(private readonly http: HttpClient) { }

  postData(title: string, price: number): Observable<any> {
    const formData = new FormData();
    formData.append('title', title);
    formData.append('price', price.toString());

    const headers = new HttpHeaders();

    return this.http.post('http://localhost:8080/api/update/price', formData, { headers, responseType: 'text' });
  }
}
