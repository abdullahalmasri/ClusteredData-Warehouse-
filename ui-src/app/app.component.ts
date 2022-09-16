import { Component } from '@angular/core';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {


  constructor() { }
  ngOnInit(): void {

    // this.appState$ = this.dealService.getDeals();
      // .pipe(map(() => { }),
      //   catchError((error: string) => {
      //     return of({ error: error })
      //   })
      // )
  }
  


}
