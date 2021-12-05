import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { ComponentsModule } from '../../components/components.module';
import { PoliceRoutingModule } from './police-routing.module';
import { PoliceComponent } from './police.component';
import { ListPoliceComponent } from './list/list.component';
import { CreatePoliceComponent } from './create/create.component';
import { UpdatePoliceComponent } from './update/update.component';
import { PoliceGeneralInformationComponent } from './update/general-information/general-information.component';
import { SituationPoliceComponent } from './update/situation/situation.component';
import { DocumentsPoliceComponent } from './update/documents/documents.component';

// UI Components
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatSelectModule } from '@angular/material/select';
import { MatIconModule } from '@angular/material/icon';
import { MatRadioModule } from '@angular/material/radio';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule, MAT_DATE_FORMATS } from '@angular/material/core';
import { MatTabsModule } from '@angular/material/tabs';
import { MaterialFileInputModule } from 'ngx-material-file-input';

const ui_components = [
  MatButtonModule,
  MatFormFieldModule,
  MatInputModule,
  MatTableModule,
  MatPaginatorModule,
  MatGridListModule,
  MatSelectModule,
  MatIconModule,
  MatRadioModule,
  MatDatepickerModule,
  MatNativeDateModule,
  MatTabsModule,
  MaterialFileInputModule
];

@NgModule({
  declarations: [
    PoliceComponent,
    ListPoliceComponent,
    CreatePoliceComponent,
    UpdatePoliceComponent,
    PoliceGeneralInformationComponent,
    SituationPoliceComponent,
    DocumentsPoliceComponent
  ],
  imports: [
    CommonModule,
    PoliceRoutingModule,
    ReactiveFormsModule,
    ComponentsModule,
    ui_components
  ],
  providers: [
    MatDatepickerModule
  ]
})
export class PoliceModule { }