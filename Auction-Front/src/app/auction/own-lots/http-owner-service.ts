import {Injectable} from "@angular/core";
import {HttpClient, HttpParams} from "@angular/common/http";
import {map, Observable} from "rxjs";

@Injectable()
export class HttpOwnerService{

  private baseUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) { }

  deleteLot(lotId: number): Observable<void> {
    const params = new HttpParams().set('id', lotId.toString());
    return this.http.get<void>(`${this.baseUrl}/delete/lot`, { params });
  }

  generateUrl(lotId: number): Observable<string> {
    const params = new HttpParams().set('id', lotId.toString());
    return this.http.get(`${this.baseUrl}/generate/url`, { params, responseType: 'arraybuffer' }).pipe(
      map((data: ArrayBuffer) => {
        const decoder = new TextDecoder('utf-8');
        return decoder.decode(data);
      })
    );
  }


  startAuction(lotId: number): Observable<void> {
    const params = new HttpParams().set('id', lotId.toString());
    return this.http.post<void>(`${this.baseUrl}/start/auction`, params);
  }

  stopAuction(lotId: number): Observable<void> {
    const params = new HttpParams().set('id', lotId.toString());
    return this.http.post<void>(`${this.baseUrl}/stop/auction`, params);
  }
}
