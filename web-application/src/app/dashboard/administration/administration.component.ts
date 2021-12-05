import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dashboard-administration',
  templateUrl: './administration.component.html'
})
export class AdministrationComponent implements OnInit {
  static pathName: string = 'administration'
  constructor() { }

  ngOnInit(): void {
  }

}
