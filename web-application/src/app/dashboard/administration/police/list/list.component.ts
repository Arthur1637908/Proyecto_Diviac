import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { PageEvent } from '@angular/material/paginator';
import { ParameterModel } from 'src/app/core/models/parameter.model';
import { SummaryPoliceModel } from 'src/app/core/models/police.model';
import { ListPoliceGetRequest, ListPoliceGetResponse } from 'src/app/core/models/services/police-service.model';
import { NotificationService } from 'src/app/core/services/notification.service';
import { ParametersService } from 'src/app/core/services/parameters.service';
import { PoliceService } from 'src/app/core/services/police.service';
import { CustomFormValidations } from 'src/app/core/utils/form-validations';
import { PoliceSearchForm } from '../shared/models';
import { CONFIRM_ACTION, DELETE_POLICE, CONFIRM_BUTTON, POLICE_DELETED } from '../shared/strings';

@Component({
  selector: 'app-police-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss']
})
export class ListPoliceComponent implements OnInit {
  static pathName: string = 'list'
  polices: SummaryPoliceModel[] = [];
  length = 0;
  pageSize = 10;
  pageSizeOptions: number[] = [2, 5, 10, 25, 100];
  currentPage = 1;
  displayedColumns: string[] = ['cip', 'names', 'lastname', 'division', 'actions'];
  filterActive = false;
  policeSearchForm = new FormGroup({
    cip: new FormControl('', [
      CustomFormValidations.validateOnlyNumbers
    ]),
    name: new FormControl('', [
      CustomFormValidations.validateAlphabetical
    ]),
    documentType: new FormControl(''),
    documentNumber: new FormControl('', [
      CustomFormValidations.validateOnlyNumbers
    ]),
  });
  documentTypes: ParameterModel[] = [];
  constructor(
    private policeService: PoliceService,
    private notificationService: NotificationService,
    private parametersService: ParametersService
  ) { }

  ngOnInit(): void {
    this.getPolices();
    this.getTypeDocuments();
  }

  getTypeDocuments(): void {
    this.parametersService
      .getParameters('TP02')
      .subscribe((response) => {
        this.documentTypes = response;
      });
  }

  getPolices(): void {
    const listPoliceGetRequest = new ListPoliceGetRequest();
    listPoliceGetRequest.name = '';
    listPoliceGetRequest.cip = '';
    listPoliceGetRequest.documentNumber = '';
    listPoliceGetRequest.documentTypeId = '';
    listPoliceGetRequest.currentPage = this.currentPage;
    listPoliceGetRequest.pageSize = this.pageSize;
    this.getPoliceService(listPoliceGetRequest);
  }

  getPoliceService(listPoliceGetRequest: ListPoliceGetRequest): void {
    this.policeService
      .getPolices(listPoliceGetRequest)
      .subscribe((response: ListPoliceGetResponse) => {
        this.polices = response.polices;
        this.length = response.page.totalNumberOfItems;
      });
  }

  validatePoliceSearchForm(policeSearchForm: PoliceSearchForm): boolean {
    return (
      (policeSearchForm.cip != '') ||
      (policeSearchForm.name != '') ||
      (policeSearchForm.documentNumber != '') ||
      (policeSearchForm.documentType != '')
    );
  }

  searchPolice(policeSearchForm: PoliceSearchForm): void {
    if (this.validatePoliceSearchForm(policeSearchForm)) {
      this.currentPage = 1;
      this.pageSize = 10;
      const listPoliceGetRequest = new ListPoliceGetRequest();
      listPoliceGetRequest.name = policeSearchForm.name;
      listPoliceGetRequest.cip = policeSearchForm.cip;
      listPoliceGetRequest.documentNumber = policeSearchForm.documentNumber;
      listPoliceGetRequest.documentTypeId = policeSearchForm.documentType;
      listPoliceGetRequest.currentPage = this.currentPage;
      listPoliceGetRequest.pageSize = this.pageSize;
      this.filterActive = true;
      this.getPoliceService(listPoliceGetRequest);
    }
  }

  handlePageEvent(event: PageEvent): void {
    this.pageSize = event.pageSize;
    this.currentPage = event.pageIndex + 1;
    const listPoliceGetRequest = new ListPoliceGetRequest();
    listPoliceGetRequest.name = '';
    listPoliceGetRequest.cip = '';
    listPoliceGetRequest.documentNumber = '';
    listPoliceGetRequest.documentTypeId = '';
    listPoliceGetRequest.currentPage = this.currentPage;
    listPoliceGetRequest.pageSize = this.pageSize;
    if (this.filterActive) {
      listPoliceGetRequest.name = this.policeSearchForm.value.name;
      listPoliceGetRequest.cip = this.policeSearchForm.value.cip;
      listPoliceGetRequest.documentNumber = this.policeSearchForm.value.documentNumber;
      listPoliceGetRequest.documentTypeId = this.policeSearchForm.value.documentType;
    }
    this.getPoliceService(listPoliceGetRequest);
  }

  resetPagination(): void {
    this.currentPage = 1;
    this.pageSize = 10;
    this.filterActive = false;
    let form = new PoliceSearchForm();
    form.cip = '';
    form.name = '';
    form.documentNumber = '';
    form.documentType = '';
    this.policeSearchForm.reset(form);
    const listPoliceGetRequest = new ListPoliceGetRequest();
    listPoliceGetRequest.name = '';
    listPoliceGetRequest.cip = '';
    listPoliceGetRequest.documentNumber = '';
    listPoliceGetRequest.documentTypeId = '';
    listPoliceGetRequest.currentPage = this.currentPage;
    listPoliceGetRequest.pageSize = this.pageSize;
    this.getPoliceService(listPoliceGetRequest);
  }

  confirmDeletePolice(policeId: string): void {
    this.notificationService.confirmNotification(
      CONFIRM_ACTION,
      DELETE_POLICE,
      CONFIRM_BUTTON,
      'warning'
    ).then((response) => {
      if (response.isConfirmed) {
        this.deletePolice(policeId);
      }
    });
  }

  deletePolice(policeId: string): void {
    this.policeService
      .deletePoliceById(policeId)
      .subscribe(() => {
        this.notificationService.successNotification(POLICE_DELETED);
        this.getPolices();
      });
  }

}
