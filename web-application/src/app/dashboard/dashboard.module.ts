import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DashboardRoutingModule } from './dashboard-routing.module';
import { DashboardComponent } from './dashboard.component';
import { NgxLoadingModule } from 'ngx-loading';
import { ComponentsModule } from './components/components.module';

@NgModule({
    imports: [
        CommonModule,
        DashboardRoutingModule,
        NgxLoadingModule.forRoot({}),
        ComponentsModule
    ],
    declarations: [
        DashboardComponent
    ]
})
export class DashboardModule {}
