import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { environment } from "src/environments/environment";
import { Book } from "../models/book.model";

@Injectable({
    providedIn: 'root'
})
export class LibraryService {
    url = environment.library_api;
    constructor(private http: HttpClient){}

    findAllBooks(): Observable<Book[]> {
        return this.http.get<Book[]>(this.url + '/books');
    }
}