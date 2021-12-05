import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';

import { ComponentsModule } from '../../components/components.module';
import { DivisionRoutingModule } from './division-routing.module';

import { DivisionComponent } from './division.component';
import { ListDivisionComponent } from './list/list.component';
import { CreateDivisionComponent } from './create/create.component';
import { UpdateDivisionComponent } from './update/update.component';

// UI Components
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatSelectModule } from '@angular/material/select';
import { MatIconModule } from '@angular/material/icon';

const ui_components = [
  MatButtonModule,
  MatFormFieldModule,
  MatInputModule,
  MatTableModule,
  MatPaginatorModule,
  MatGridListModule,
  MatSelectModule,
  MatIconModule
];

@NgModule({
  declarations: [
    DivisionComponent,
    ListDivisionComponent,
    CreateDivisionComponent,
    UpdateDivisionComponent
  ],
  imports: [
    CommonModule,
    DivisionRoutingModule,
    ReactiveFormsModule,
    ComponentsModule,
    ...ui_components
  ]
})
export class DivisionModule { }
