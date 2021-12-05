import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';

@Component({
    selector: 'app-dashboard',
    templateUrl: './dashboard.component.html',
    styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {
    static pathName: string = 'dashboard';
    public loading: boolean = false;

    constructor() { }

    ngOnInit(): void {
    }

}
