import { Component, Input, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { DateAdapter, MAT_DATE_FORMATS } from '@angular/material/core';
import { ParameterModel } from 'src/app/core/models/parameter.model';
import { PoliceGeneralInformation } from 'src/app/core/models/policeGeneralInformation.model';
import { CreatePolicePostRequest } from 'src/app/core/models/services/police-service.model';
import { NotificationService } from 'src/app/core/services/notification.service';
import { ParametersService } from 'src/app/core/services/parameters.service';
import { PoliceService } from 'src/app/core/services/police.service';
import { CustomFormValidations } from 'src/app/core/utils/form-validations';
import { AppDateAdapter, APP_DATE_FORMATS } from 'src/app/core/utils/format-datepicker';
import { CONFIRM_ACTION, CONFIRM_BUTTON, SAVE_CHANGES_NOTIFY } from '../../../division/shared/strings';
import { CreatePoliceGeneralInformationForm } from '../../shared/models';
import { POLICE_UPDATED } from '../../shared/strings';
import * as moment from 'moment';
export default moment;

@Component({
  selector: 'app-police-general-information',
  templateUrl: './general-information.component.html',
  styleUrls: [],
  providers: [
    { provide: DateAdapter, useClass: AppDateAdapter },
    { provide: MAT_DATE_FORMATS, useValue: APP_DATE_FORMATS },
  ]
})
export class PoliceGeneralInformationComponent implements OnInit {
  @Input() policeId: string = '';
  currentDivisionIdSelected: string = '';
  currentDivisionName?: string = '';
  generalInformation = new PoliceGeneralInformation();
  maritalStatus: ParameterModel[] = [];
  positions: ParameterModel[] = [];
  grades: ParameterModel[] = [];
  genders: ParameterModel[] = [];
  policeGeneralInformationForm = new FormGroup({
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
    private dateAdapter: DateAdapter<Date>
  ) {
    this.dateAdapter.setLocale('es');
  }

  ngOnInit(): void {
    this.getMaritalStatuses();
    this.getPositions();
    this.getGrades();
    this.getGenders();
    this.getPoliceGeneralInformation(this.policeId);
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

  getPoliceGeneralInformation(policeId: string): void {
    this.policeService
      .getPoliceGeneralInformationById(policeId)
      .subscribe((response: PoliceGeneralInformation) => {
        this.generalInformation = response;
        this.setOriginalValues(response);
      });
  }

  confirmUpdatePoliceGeneralInformation(policeGeneralInformationForm: CreatePoliceGeneralInformationForm): void {
    this.notificationService.confirmNotification(
      CONFIRM_ACTION,
      SAVE_CHANGES_NOTIFY,
      CONFIRM_BUTTON,
      'warning'
    ).then((response) => {
      if (response.isConfirmed) {
        this.updatePoliceGeneralInformation(policeGeneralInformationForm);
      }
    });
  }

  updatePoliceGeneralInformation(policeGeneralInformationForm: CreatePoliceGeneralInformationForm): void {
    let policeGeneralInformation = new CreatePolicePostRequest();
    policeGeneralInformation.cip = policeGeneralInformationForm.cip;
    policeGeneralInformation.civilStatusId = parseInt(policeGeneralInformationForm.civilStatusId);
    policeGeneralInformation.dateOfBirth = moment(policeGeneralInformationForm.dateOfBirth).format('DD/MM/YYYY');
    policeGeneralInformation.divisionId = this.currentDivisionIdSelected;
    policeGeneralInformation.firstName = policeGeneralInformationForm.firstName.toUpperCase();
    policeGeneralInformation.gradeId = parseInt(policeGeneralInformationForm.gradeId);
    policeGeneralInformation.lastName = policeGeneralInformationForm.lastName.toUpperCase();
    policeGeneralInformation.positionId = parseInt(policeGeneralInformationForm.positionId);
    policeGeneralInformation.pseudonym = policeGeneralInformationForm.pseudonym.toUpperCase();
    policeGeneralInformation.secondLastName = policeGeneralInformationForm.secondLastName.toUpperCase();
    policeGeneralInformation.secondName = policeGeneralInformationForm.secondName.toUpperCase();
    policeGeneralInformation.sexId = parseInt(policeGeneralInformationForm.genderId);

    this.policeService
      .updatePoliceGeneralInformationById(this.policeId, policeGeneralInformation)
      .subscribe((response) => {
        this.generalInformation = response;
        this.setOriginalValues(response);
        this.notificationService.successNotification(POLICE_UPDATED);
      });
  }

  setOriginalValues(response: PoliceGeneralInformation): void {
    const dateParts = response.dateOfBirth.split("/");
    const dateObject = new Date(+dateParts[2], parseInt(dateParts[1]) - 1, +dateParts[0]);
    this.policeGeneralInformationForm.setValue({
      cip: response.cip,
      pseudonym: response.pseudonym,
      firstName: response.firstName,
      secondName: response.secondName,
      lastName: response.lastName,
      secondLastName: response.secondLastName,
      positionId: response.position.id,
      gradeId: response.grade.id,
      civilStatusId: response.civilStatus.id,
      genderId: parseInt(response.sex.id),
      dateOfBirth: dateObject
    });
    this.currentDivisionName = response.division.name;
    this.currentDivisionIdSelected = response.division.id;
  }

  divisionSelected(divisionId: string): void {
    this.currentDivisionIdSelected = divisionId;
  }

}
