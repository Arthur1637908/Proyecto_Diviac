import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdministrationRoutingModule } from './administration-routing.module';

import { DivisionModule } from './division/division.module';
import { AdministrationComponent } from './administration.component';
import { PoliceModule } from './police/police.module';

@NgModule({
    declarations: [
        AdministrationComponent
    ],
    imports: [
        CommonModule,
        AdministrationRoutingModule,
        DivisionModule,
        PoliceModule
    ]
})
export class AdministrationModule {}
