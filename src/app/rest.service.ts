import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { map, catchError, tap } from 'rxjs/operators';

const endpoint = 'http://localhost:8080/core/api/v1/';
const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class RestService {

  constructor(private http: HttpClient) { }

  getGenre(): Observable<any> {
    return this.http.get(endpoint + 'genre').pipe(
      map(this.extractData));
  }

   getGenreById(id): Observable<any> {
    return this.http.get(endpoint + 'track/' + id, httpOptions).pipe(
      map(this.extractData));
  }


  addGenre(genre): Observable<any> {
    console.log(genre);
    return this.http.post<any>(endpoint + 'genre', JSON.stringify(genre), httpOptions).pipe(
      tap((genre) => console.log(`added genre w/ id=${genre.id}`)),
      catchError(this.handleError<any>('addGenre'))
    );
  }

  getTracks(): Observable<any> {
    return this.http.get(endpoint + 'track').pipe(
      map(this.extractData));
  }

  addTrack(track): Observable<any> {
    console.log(track);
    return this.http.post<any>(endpoint + 'track', JSON.stringify(track), httpOptions).pipe(
      tap((track) => console.log(`added track w/ id=${track.id}`)),
      catchError(this.handleError<any>('addTrack'))
    );
  }


  updateTrack(): Observable<any> {
    return this.http.get(endpoint + 'track').pipe(
      map(this.extractData));
  }

  updateGenre(): Observable<any> {
    return this.http.get(endpoint + 'track').pipe(
      map(this.extractData));
  }

  deleteTrack(id): Observable<any> {
    return this.http.delete<any>(endpoint + 'track/' + id, httpOptions).pipe(
      tap(_ => console.log(`deleted track id=${id}`)),
      catchError(this.handleError<any>('deleteTrack'))
    );
  }

  deleteGenre(id): Observable<any> {
    return this.http.delete<any>(endpoint + 'genre/' + id, httpOptions).pipe(
      tap(_ => console.log(`deleted genre id=${id}`)),
      catchError(this.handleError<any>('deleteGenre'))
    );
  }

  private extractData(res: Response) {
    let body = res;
    return body || {};
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      console.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
}
