import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { DateAdapter, MAT_DATE_FORMATS } from '@angular/material/core';
import { Router } from '@angular/router';
import { ParameterModel } from 'src/app/core/models/parameter.model';
import { CreatePolicePostRequest } from 'src/app/core/models/services/police-service.model';
import { NotificationService } from 'src/app/core/services/notification.service';
import { ParametersService } from 'src/app/core/services/parameters.service';
import { PoliceService } from 'src/app/core/services/police.service';
import { AppDateAdapter, APP_DATE_FORMATS } from 'src/app/core/utils/format-datepicker';
import { CreatePoliceGeneralInformationForm } from '../shared/models';
import { POLICE_CREATED } from '../shared/strings';
import * as moment from 'moment';
export default moment;
import { CustomFormValidations } from 'src/app/core/utils/form-validations';
import { PoliceModel } from 'src/app/core/models/police.model';

@Component({
  selector: 'app-police-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.scss'],
  providers: [
    { provide: DateAdapter, useClass: AppDateAdapter },
    { provide: MAT_DATE_FORMATS, useValue: APP_DATE_FORMATS },
  ]
})
export class CreatePoliceComponent implements OnInit {
  static pathName: string = 'crear';
  currentDivisionIdSelected: string = '';
  maritalStatus: ParameterModel[] = [];
  positions: ParameterModel[] = [];
  grades: ParameterModel[] = [];
  genders: ParameterModel[] = [];
  policeForm = new FormGroup({
    cip: new FormControl('', [
      Validators.required,
      CustomFormValidations.validateOnlyNumbers
    ]),
    pseudonym: new FormControl('', [
      CustomFormValidations.validateAlphabeticalWithoutSpace
    ]),
    firstName: new FormControl('', [
      Validators.required,
      CustomFormValidations.validateAlphabeticalWithoutSpace
    ]),
    secondName: new FormControl('', [
      CustomFormValidations.validateAlphabeticalWithoutSpace
    ]),
    lastName: new FormControl('', [
      Validators.required,
      CustomFormValidations.validateAlphabeticalWithoutSpace
    ]),
    secondLastName: new FormControl('', [
      Validators.required,
      CustomFormValidations.validateAlphabeticalWithoutSpace
    ]),
    positionId: new FormControl('', [
      Validators.required
    ]),
    gradeId: new FormControl('', [
      Validators.required
    ]),
    civilStatusId: new FormControl(''),
    genderId: new FormControl('', [
      Validators.required
    ]),
    dateOfBirth: new FormControl('', [
      Validators.required
    ])
  })

  constructor(
    private parametersService: ParametersService,
    private notificationService: NotificationService,
    private policeService: PoliceService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.getMaritalStatuses();
    this.getPositions();
    this.getGrades();
    this.getGenders();
  }

  getMaritalStatuses(): void {
    this.parametersService
      .getParameters('TP04')
      .subscribe((response) => {
        this.maritalStatus = response;
      });
  }

  getPositions(): void {
    this.parametersService
      .getParameters('TP06')
      .subscribe((response) => {
        this.positions = response;
      });
  }

  getGrades(): void {
    this.parametersService
      .getParameters('TP08')
      .subscribe((response) => {
        this.grades = response;
      });
  }

  getGenders(): void {
    this.parametersService
      .getParameters('TP05')
      .subscribe((response) => {
        this.genders = response;
      });
  }

  createPolice(policeForm: CreatePoliceGeneralInformationForm): void {
    let police = new CreatePolicePostRequest();
    police.cip = policeForm.cip;
    police.civilStatusId = parseInt(policeForm.civilStatusId);
    police.dateOfBirth = moment(policeForm.dateOfBirth).format('DD/MM/YYYY');
    police.divisionId = this.currentDivisionIdSelected;
    police.firstName = policeForm.firstName.toUpperCase();
    police.gradeId = parseInt(policeForm.gradeId);
    police.lastName = policeForm.lastName.toUpperCase();
    police.positionId = parseInt(policeForm.positionId);
    police.pseudonym = policeForm.pseudonym.toUpperCase();
    police.secondLastName = policeForm.secondLastName.toUpperCase();
    police.secondName = policeForm.secondName.toUpperCase();
    police.sexId = parseInt(policeForm.genderId);
    this.policeService.createPolice(police).subscribe((response: PoliceModel) => {
      this.notificationService.successNotification(POLICE_CREATED).then((res) => {
        this.goToPoliceDetail(response.id)
      });
    });
  }

  goToPoliceDetail(policeId: string): void {
    this.router.navigate([`/dashboard/efectivo/${policeId}`]);
  }

  divisionSelected(divisionId: string): void {
    this.currentDivisionIdSelected = divisionId;
  }

}
