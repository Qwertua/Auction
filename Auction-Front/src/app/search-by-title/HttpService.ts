import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable()
export class HttpService{
  constructor(private readonly http: HttpClient) { }

  getData(title: string): Observable<any> {
    const url = 'http://localhost:8080/api/search/lot';

    const params = { title: title };

    return this.http.get(url, { params: params });
  }
}
