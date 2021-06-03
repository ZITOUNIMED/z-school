import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { environment } from "src/environments/environment";
import { Section } from "../models/section.model";

@Injectable({
    providedIn: 'root'
})
export class AdministrationService {
    url = environment.administration_api;
    constructor(private http: HttpClient){}

    findAllSections(): Observable<Section[]> {
        return this.http.get<Section[]>(this.url + '/sections');
    }
}