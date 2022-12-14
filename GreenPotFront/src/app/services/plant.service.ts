import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {PlantAllDataDto} from "../dto/plantAllDataDto";
import {Observable} from "rxjs";
import {BASE_URL} from "../utility/globals";
import {Plant} from "../models/plant";

@Injectable({
  providedIn: 'root'
})
export class PlantService {

  constructor( private http: HttpClient) { }

  baseUrl = BASE_URL + '/plant'

  getAllDataPlantById(id: number): Observable<PlantAllDataDto> {
    let url = this.baseUrl + '/info/id';
    return this.http.get<PlantAllDataDto>(url,{
      params: new HttpParams().set('id',id)
    });
  }

  getAllPlants(): Observable<PlantAllDataDto[]>{
    let url = this.baseUrl + '/all'
    return this.http.get<PlantAllDataDto[]>(url)
  }

  getPlantByMainCategory(category: string):Observable<PlantAllDataDto[]>{
    let url = this.baseUrl + '/category'
    let httpParams = new HttpParams().set('category',category)
    return this.http.get<PlantAllDataDto[]>(url,{params: httpParams})
  }
}
