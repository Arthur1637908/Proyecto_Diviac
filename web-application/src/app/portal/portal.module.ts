import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PortalRoutingModule } from './portal-routing.module';

import { HeaderComponent } from './components/header/header.component';
import { HomeComponent } from './home/home.component';
import { FooterComponent } from './components/footer/footer.component';
import { PortalComponent } from './portal.component';
import { ClosedSourcesComponent } from './closed-sources/closed-sources.component';
import { IvyCarouselModule } from 'angular-responsive-carousel';

// Views
let views = [
    HomeComponent,
    ClosedSourcesComponent
];

// Components
let components = [
    HeaderComponent,
    FooterComponent
];

@NgModule({
    declarations: [
        PortalComponent,
        ...views,
        ...components
    ],
    imports: [
        CommonModule,
        PortalRoutingModule,
        IvyCarouselModule
    ]
})
export class PortalModule {
    static pathName: string = '';
}
