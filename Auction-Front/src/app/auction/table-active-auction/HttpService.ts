import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Lots} from "./Lots";

@Injectable()
export class HttpService{
  constructor(private readonly http: HttpClient) { }

    getActiveLots(){
      return this.http.get<Lots[]>("http://localhost:8080/api/active/lots");
    }
}
