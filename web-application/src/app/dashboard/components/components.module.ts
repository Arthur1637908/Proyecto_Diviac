import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

import { VerticalMenuComponent } from './vertical-menu/vertical-menu.component';
import { ToolbarComponent } from './toolbar/toolbar.component';
import { BackButtonComponent } from './back-button/back-button.component';
import { DivisionDropdownPaginationComponent } from './division-dropdown-pagination/division-dropdown-pagination.component';

import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatListModule } from '@angular/material/list';
import { MatPaginatorModule } from '@angular/material/paginator';
import { ReactiveFormsModule } from '@angular/forms';

const ui_components = [
  MatButtonModule,
  MatIconModule,
  MatFormFieldModule,
  MatInputModule,
  MatListModule,
  MatPaginatorModule
];

@NgModule({
  declarations: [
    VerticalMenuComponent,
    ToolbarComponent,
    BackButtonComponent,
    DivisionDropdownPaginationComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    ReactiveFormsModule,
    ...ui_components
  ],
  exports: [
    VerticalMenuComponent,
    ToolbarComponent,
    BackButtonComponent,
    DivisionDropdownPaginationComponent
  ]
})
export class ComponentsModule { }