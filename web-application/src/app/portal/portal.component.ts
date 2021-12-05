import { Component, OnInit } from '@angular/core';

@Component({
    selector: 'app-portal',
    templateUrl: './portal.component.html'
})
export class PortalComponent implements OnInit {
    static pathName: string = '';
    constructor() { }

    ngOnInit(): void {
    }

}
