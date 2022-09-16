import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { tap, catchError } from 'rxjs/operators';
import { deal } from '../interface/deal';

@Injectable({
  providedIn: 'root'
})
export class DealService {

  private readonly apiUrl= 'localhost:8585/api/v1';

  constructor(private http:HttpClient) { }

  read$ = <Observable<deal>>
  this.http.get<deal[]>(`${this.apiUrl}/findDeals`)
  .pipe(
    tap(console.log),
    catchError(this.handerError)
  )
  save$ = (deal:deal) => <Observable<deal>>
  this.http.post<deal>(`${this.apiUrl}/saveDeal`,deal)
  .pipe(
    tap(console.log),
    catchError(this.handerError)
  )

  handerError(error: HttpErrorResponse): Observable<never> {
    console.log(error);
    return throwError(`An error happened - Error Code: ${error.status}`);
  }
  public getDeals():Observable<deal[]>{
    return this.http.get<deal[]>(`http://localhost:8080/api/v1/findDeals`);
  }

}
