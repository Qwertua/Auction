import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {BehaviorSubject, Observable, Subject} from "rxjs";
import {user} from "./user";

@Injectable()
export class AuthService {
  private baseUrl = 'http://localhost:8080/api';
  private user: user[] = [];
  private userSubject = new BehaviorSubject<user[]>([]);
  userData$ = this.userSubject.asObservable();

  constructor(private http: HttpClient) {}

  register(user: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/register`, user);
  }

  login(name: string, password: string): Observable<user[]> {
    const formData = new FormData();
    formData.append('name', name);
    formData.append('password', password);
    const headers = new HttpHeaders();
    return this.http.post<user[]>(`${this.baseUrl}/login`, formData);
  }


  getUserObservable(): Observable<user[]> {
    return this.userSubject.asObservable();
  }

  setUser(user: user[]) {
    console.log(user);
    this.userSubject.next(user);
  }

  getUser() {
    console.log(this.user);
    return this.user;
  }
}
