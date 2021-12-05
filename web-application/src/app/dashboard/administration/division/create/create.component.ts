import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
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
import { DIVISION_CREATED } from '../shared/strings';

@Component({
  selector: 'app-division-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.scss']
})
export class CreateDivisionComponent implements OnInit {
  static pathName: string = 'crear';
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
    address: new FormControl('', [ 
      Validators.required,
      CustomFormValidations.validateAlphanumeric('-/.')
    ]),
    addressNumber: new FormControl('', [
      Validators.required,
      CustomFormValidations.validateAlphanumeric('-/.')
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

  constructor(
    private notificationService: NotificationService,
    private ubigeoService: UbigeoService,
    private parametersService: ParametersService,
    private divisionService: DivisionService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.getParameters();
    this.getDepartments();
  }

  getParameters(): void {
    this.parametersService.getParameters(TP01).subscribe((response: ParameterModel[]) => {
      this.parameters = response;
    });
  }

  getDepartments(): void {
    this.ubigeoService.getDepartments().subscribe((response: UbigeoModel[]) => {
      this.departments = response;
    });
  }

  departmentChange(event: any): void {
    if (event.value) this.getProvinces(event.value);
  }

  getProvinces(departmentId: string): void {
    this.ubigeoService.getProvinces(departmentId).subscribe((response: UbigeoModel[]) => {
      this.provinces = response;
    });
  }

  provinceChange(event: any): void {
    if (event.value) this.getDistricts(event.value);
  }

  getDistricts(provinceId: string): void {
    this.ubigeoService.getDistricts(provinceId).subscribe((response: UbigeoModel[]) => {
      this.districts = response;
    });
  }

  createDivision(divisionForm: CreateDivisionForm): void {
    let division = new DivisionModel();
    division.name = divisionForm.name.toUpperCase();
    division.acronym = divisionForm.acronym.toUpperCase();
    division.description = divisionForm.description.toUpperCase();
    let addressDivision = new AddressModel();
    addressDivision.name = divisionForm.address.toUpperCase();
    addressDivision.departmentId = divisionForm.department;
    addressDivision.provinceId = divisionForm.province;
    addressDivision.districtId = divisionForm.district;
    addressDivision.typeId = divisionForm.typeAddress;
    addressDivision.number = divisionForm.addressNumber.toUpperCase();
    division.address = addressDivision;
    let contactDivision = new ContactModel();
    contactDivision.email = divisionForm.email.toUpperCase();
    contactDivision.phoneNumber = divisionForm.phoneNumber;
    contactDivision.annexNumber = divisionForm.annex;
    division.contact = contactDivision;

    this.divisionService.createDivision(division).subscribe(() => {
      this.notificationService.successNotification(DIVISION_CREATED).then((res) => {
        this.goToListDivisions()
      });
    });
  }

  goToListDivisions(): void {
    this.router.navigate(['/dashboard']);
  }

}
