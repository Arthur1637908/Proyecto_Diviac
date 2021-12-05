import { BrowserModule } from '@angular/platform-browser';
import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { KeycloakAngularModule } from 'keycloak-angular';

import { AppRoutingModule } from './app-routing.module';
import { PortalModule } from './portal/portal.module';
import { AppComponent } from './app.component';
import { AuthGuard } from './core/guards/auth.guard';
import { Keycloak } from './core/services/keycloak.service';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { NgxLoadingModule } from 'ngx-loading';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { IvyCarouselModule } from 'angular-responsive-carousel';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    KeycloakAngularModule,
    AppRoutingModule,
    NgxLoadingModule.forRoot({}),
    PortalModule,
    BrowserAnimationsModule,
    IvyCarouselModule
  ],
  providers: [
    AuthGuard,
    Keycloak
  ],
  schemas: [
    CUSTOM_ELEMENTS_SCHEMA
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
