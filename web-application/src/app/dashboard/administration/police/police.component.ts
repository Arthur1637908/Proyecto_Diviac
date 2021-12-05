import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dashboard-police',
  templateUrl: './police.component.html'
})
export class PoliceComponent implements OnInit {
  static pathName: string = 'efectivo'
  constructor() { }

  ngOnInit(): void {
  }

}
