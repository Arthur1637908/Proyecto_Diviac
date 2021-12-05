import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-portal-closed-sources',
  templateUrl: './closed-sources.component.html',
  styleUrls: ['./closed-sources.component.scss']
})
export class ClosedSourcesComponent implements OnInit {
  static pathName: string = 'fuentes-cerrada'
  constructor() { }

  ngOnInit(): void {
  }

}
