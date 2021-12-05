import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { PageEvent } from '@angular/material/paginator';
import { DivisionModel } from 'src/app/core/models/division.model';
import { DivisionGetRequest, DivisionGetResponse } from 'src/app/core/models/services/division-service.model';
import { DivisionService } from 'src/app/core/services/division.service';
import { NotificationService } from 'src/app/core/services/notification.service';
import { CustomFormValidations } from 'src/app/core/utils/form-validations';
import { DivisionSearchForm } from '../shared/models';
import { CONFIRM_ACTION, CONFIRM_BUTTON, DELETE_DIVISION, DIVISION_DELETED } from '../shared/strings';

@Component({
  selector: 'app-division-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss']
})
export class ListDivisionComponent implements OnInit {
  static pathName: string = 'list';
  divisions: DivisionModel[] = [];
  length = 0;
  pageSize = 10;
  pageSizeOptions: number[] = [2, 5, 10, 25, 100];
  currentPage = 1;
  displayedColumns: string[] = ['code', 'name', 'acronym', 'actions'];
  filterActive = false;
  divisionSearchForm = new FormGroup({
    code: new FormControl('', [
      Validators.minLength(3),
      CustomFormValidations.validateAlphanumericWithoutSpace
    ]),
    name: new FormControl('', [
      Validators.minLength(3),
      CustomFormValidations.validateAlphabetical
    ]),
  });
  constructor(
    private divisionService: DivisionService,
    private notificationService: NotificationService
  ) { }

  ngOnInit(): void {
    this.getDivisions();
  }

  getDivisions(): void {
    const divisionGetRequest = new DivisionGetRequest();
    divisionGetRequest.name = '';
    divisionGetRequest.code = '';
    divisionGetRequest.currentPage = this.currentPage;
    divisionGetRequest.pageSize = this.pageSize;
    this.getDivisionService(divisionGetRequest);
  }

  getDivisionService(divisionGetRequest: DivisionGetRequest): void {
    this.divisionService
      .getDivisions(divisionGetRequest)
      .subscribe((response: DivisionGetResponse) => {
        this.divisions = response.divisions;
        this.length = response.page.totalNumberOfItems;
      });
  }

  validateDivisionSearchForm(divisionSearchForm: DivisionSearchForm): boolean {
    return ((divisionSearchForm.code != '') || (divisionSearchForm.name != ''));
  }

  searchDivision(divisionSearchForm: DivisionSearchForm): void {
    if (this.validateDivisionSearchForm(divisionSearchForm)) {
      this.currentPage = 1;
      this.pageSize = 10;
      const divisionGetRequest = new DivisionGetRequest();
      divisionGetRequest.name = divisionSearchForm.name;
      divisionGetRequest.code = divisionSearchForm.code;
      divisionGetRequest.currentPage = this.currentPage;
      divisionGetRequest.pageSize = this.pageSize;
      this.filterActive = true;
      this.getDivisionService(divisionGetRequest);
    }
  }

  handlePageEvent(event: PageEvent): void {
    this.pageSize = event.pageSize;
    this.currentPage = event.pageIndex + 1;
    const divisionGetRequest = new DivisionGetRequest();
    divisionGetRequest.name = '';
    divisionGetRequest.code = '';
    divisionGetRequest.currentPage = this.currentPage;
    divisionGetRequest.pageSize = this.pageSize;
    if (this.filterActive) {
      divisionGetRequest.name = this.divisionSearchForm.value.name;
      divisionGetRequest.code = this.divisionSearchForm.value.code;
    }
    this.getDivisionService(divisionGetRequest);
  }

  resetPagination(): void {
    this.currentPage = 1;
    this.pageSize = 10;
    this.filterActive = false;
    let form = new DivisionSearchForm();
    form.code = '';
    form.name = '';
    this.divisionSearchForm.reset(form)
    const divisionGetRequest = new DivisionGetRequest();
    divisionGetRequest.name = '';
    divisionGetRequest.code = '';
    divisionGetRequest.currentPage = this.currentPage;
    divisionGetRequest.pageSize = this.pageSize;
    this.getDivisionService(divisionGetRequest);
  }

  confirmDeleteDivision(divisionId: string): void {
    this.notificationService.confirmNotification(
      CONFIRM_ACTION,
      DELETE_DIVISION,
      CONFIRM_BUTTON,
      'warning'
    ).then((response) => {
      if (response.isConfirmed) {
        this.deleteDivision(divisionId);
      }
    });
  }

  deleteDivision(divisionId: string): void {
    this.divisionService
      .deleteDivisionById(divisionId)
      .subscribe(() => {
        this.notificationService.successNotification(DIVISION_DELETED);
        this.getDivisions();
      });
  }

}
