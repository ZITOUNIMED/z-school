import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { environment } from "src/environments/environment";
import { User } from "../models/user.model";

@Injectable({
    providedIn: 'root'
})
export class UsersService {
    url = environment.users_api;
    constructor(private http: HttpClient){}

    findAllUsers(): Observable<User[]> {
        return this.http.get<User[]>(this.url + '/users');
    }
}