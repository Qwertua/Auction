import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {BehaviorSubject, Observable, Subject, tap} from "rxjs";
import {user} from "./user";

@Injectable()
export class AuthService {
  private baseUrl = 'http://localhost:8080/api';
  private user: user | undefined;
  private userSubject = new BehaviorSubject<user | undefined>(undefined);
  userData$ = this.userSubject.asObservable();
  private userKey = 'userData';

  constructor(private http: HttpClient) {
    const storedUser = localStorage.getItem(this.userKey);
    if (storedUser) {
      this.user = JSON.parse(storedUser);
    }
  }

  register(name: string, password: string): Observable<user> {
    const body = new URLSearchParams();
    body.set('name', name);
    body.set('password', password);
    const headers = new HttpHeaders({
      'Content-Type': 'application/x-www-form-urlencoded'
    });
    return this.http.post<user>(`${this.baseUrl}/register`, body.toString(), { headers });
  }

  login(name: string, password: string): Observable<user> {
    const formData = new FormData();
    formData.append('name', name);
    formData.append('password', password);
    const headers = new HttpHeaders();

    return this.http.post<user>(`${this.baseUrl}/login`, formData)
      .pipe(tap((user: user) => {
        if (user) {
          this.user = user;
          this.saveUserToLocalStorage(user);
        }
      }));
  }

  setUser(user: user) {
    this.user = user;
    this.userSubject.next(user);
  }

  getUser() {
    console.log(this.user);
    return this.user;
  }

  private saveUserToLocalStorage(user: user) {
    localStorage.setItem(this.userKey, JSON.stringify(user));
  }
}
