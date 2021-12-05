import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { AddressModel } from 'src/app/core/models/address.model';
import { ContactModel } from 'src/app/core/models/contact.model';
import { DivisionModel } from 'src/app/core/models/division.model';
import { ParameterModel } from 'src/app/core/models/parameter.model';
import { UbigeoModel } from 'src/app/core/models/ubigeo.model';
import { DivisionService } from 'src/app/core/services/division.service';
import { NotificationService } from 'src/app/core/services/notification.service';
import { ParametersService } from 'src/app/core/services/parameters.service';
import { UbigeoService } from 'src/app/core/services/ubigeo.service';
import { CustomFormValidations } from 'src/app/core/utils/form-validations';
import { TP01 } from 'src/app/dashboard/shared/constants/parameter.constant';
import { CreateDivisionForm } from '../shared/models';
import { CONFIRM_ACTION, SAVE_CHANGES_NOTIFY, DIVISION_UPDATED, CONFIRM_BUTTON } from '../shared/strings';

@Component({
  selector: 'app-division-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.scss']
})
export class UpdateDivisionComponent implements OnInit {
  static pathName: string = ':id';
  divisionCode: string = '';
  divisionId: string = '';
  divisionForm = new FormGroup({
    name: new FormControl('', [
      Validators.required,
      CustomFormValidations.validateAlphabetical
    ]),
    acronym: new FormControl('', [
      CustomFormValidations.validateAlphanumericWithoutSpace
    ]),
    description: new FormControl(''),
    department: new FormControl('', Validators.required),
    province: new FormControl('', Validators.required),
    district: new FormControl('', Validators.required),
    typeAddress: new FormControl('', Validators.required),
    address: new FormControl('', Validators.required),
    addressNumber: new FormControl('', [
      Validators.required,
    ]),
    email: new FormControl('', [
      Validators.required,
      Validators.email,
      CustomFormValidations.validateGobCustomEmail
    ]),
    phoneNumber: new FormControl('', [
      Validators.required,
      CustomFormValidations.validateLandlineOrMobilePhone
    ]),
    annex: new FormControl('', [
      CustomFormValidations.validateOnlyNumbers
    ]),
  });
  departments: UbigeoModel[] = [];
  provinces: UbigeoModel[] = [];
  districts: UbigeoModel[] = [];
  parameters: ParameterModel[] = [];
  division = new DivisionModel();
  constructor(
    private notificationService: NotificationService,
    private ubigeoService: UbigeoService,
    private parametersService: ParametersService,
    private divisionService: DivisionService,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.divisionId = params['id'];
      this.getDivisionDetail(this.divisionId);
    });
    this.getParameters();
    this.getDepartments();
  }

  getParameters(): void {
    this.parametersService.getParameters(TP01).subscribe((response: ParameterModel[]) => {
      this.parameters = response;
    });
  }

  getDepartments() {
    this.ubigeoService.getDepartments().subscribe((response: UbigeoModel[]) => {
      this.departments = response;
    });
  }

  departmentChange(event: any): void {
    if (event.value) this.getProvinces(event.value);
  }

  getProvinces(departmentId: string) {
    this.ubigeoService.getProvinces(departmentId).subscribe((response: UbigeoModel[]) => {
      this.provinces = response;
    });
  }

  provinceChange(event: any): void {
    if (event.value) this.getDistricts(event.value);
  }

  getDistricts(provinceId: string) {
    this.ubigeoService.getDistricts(provinceId).subscribe((response: UbigeoModel[]) => {
      this.districts = response;
    });
  }

  getDivisionDetail(divisionId: string): void {
    this.divisionService.getDivisionById(divisionId).subscribe((response: DivisionModel) => {
      this.division = response;
      this.setOriginalValues(this.division);
      this.getProvinces(this.division.address.departmentId);
      this.getDistricts(this.division.address.provinceId);
    });
  }

  confirmUpdateDivision(divisionForm: CreateDivisionForm): void {
    this.notificationService.confirmNotification(
      CONFIRM_ACTION,
      SAVE_CHANGES_NOTIFY,
      CONFIRM_BUTTON,
      'warning'
    ).then((response) => {
      if (response.isConfirmed) {
        this.updateDivision(divisionForm);
      }
    });
  }

  updateDivision(divisionForm: CreateDivisionForm): void {
    let division = new DivisionModel();
    division.name = divisionForm.name;
    division.acronym = divisionForm.acronym;
    division.description = divisionForm.description;
    let addressDivision = new AddressModel();
    addressDivision.name = divisionForm.address;
    addressDivision.districtId = divisionForm.district;
    addressDivision.number = divisionForm.addressNumber;
    addressDivision.typeId = divisionForm.typeAddress;
    division.address = addressDivision;
    let contactDivision = new ContactModel();
    contactDivision.email = divisionForm.email;
    contactDivision.phoneNumber = divisionForm.phoneNumber;
    contactDivision.annexNumber = divisionForm.annex;
    division.contact = contactDivision;

    this.divisionService
      .updateDivisionById(this.divisionId, division)
      .subscribe((response) => {
        this.division = response;
        this.setOriginalValues(this.division);
        this.notificationService.successNotification(DIVISION_UPDATED);
      });
  }

  setOriginalValues(response: DivisionModel): void {
    this.divisionCode = response.code;
    this.divisionForm.setValue({
      name: response.name,
      acronym: response.acronym,
      description: response.description,
      department: response.address.departmentId,
      district: response.address.districtId,
      province: response.address.provinceId,
      typeAddress: response.address.typeId,
      address: response.address.name,
      addressNumber: response.address.number,
      email: response.contact.email,
      phoneNumber: response.contact.phoneNumber,
      annex: response.contact.annexNumber
    })
  }

}
