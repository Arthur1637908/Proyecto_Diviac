import { Component, Input, OnInit, Output } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { PageEvent } from '@angular/material/paginator';
import { EventEmitter } from '@angular/core';
import { DivisionModel } from 'src/app/core/models/division.model';
import { DivisionGetRequest, DivisionGetResponse } from 'src/app/core/models/services/division-service.model';
import { DivisionService } from 'src/app/core/services/division.service';
import { CustomFormValidations } from 'src/app/core/utils/form-validations';
import { DivisionSearchForm } from '../../administration/division/shared/models';

@Component({
  selector: 'app-division-dropdown-pagination',
  templateUrl: './division-dropdown-pagination.component.html',
  styleUrls: ['./division-dropdown-pagination.component.scss'],
})
export class DivisionDropdownPaginationComponent implements OnInit {
  @Output() divisionSelected = new EventEmitter<string>();
  @Input() initialValue: string = '';
  filterActive: boolean = false;
  divisions: DivisionModel[] = [];
  length = 0;
  pageSize = 10;
  currentPage = 1;
  divisionSearchForm = new FormGroup({
    name: new FormControl('', [
      CustomFormValidations.validateAlphabetical
    ]),
    code: new FormControl(''),
  });
  constructor(
    private divisionService: DivisionService
  ) { }

  ngOnInit(): void {
    if (this.initialValue != '') {
      let form = new DivisionSearchForm();
      form.code = '';
      form.name = this.initialValue;
      this.divisionSearchForm.reset(form);
    }
  }

  searchDivision(divisionSearchForm: DivisionSearchForm): void {
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

  getDivisionService(divisionGetRequest: DivisionGetRequest): void {
    this.divisionService
      .getDivisions(divisionGetRequest)
      .subscribe((response: DivisionGetResponse) => {
        this.divisions = response.divisions;
        this.length = response.page.totalNumberOfItems;
      });
  }

  handlePageEvent(event: PageEvent): void {
    this.pageSize = event.pageSize;
    this.currentPage = event.pageIndex + 1;
    const divisionGetRequest = new DivisionGetRequest();
    divisionGetRequest.name = '';
    divisionGetRequest.code = '';
    divisionGetRequest.currentPage = this.currentPage;
    divisionGetRequest.pageSize = this.pageSize;
    this.getDivisionService(divisionGetRequest);
  }

  resetPagination(): void {
    this.currentPage = 1;
    this.pageSize = 10;
    this.filterActive = false;
    let form = new DivisionSearchForm();
    form.code = '';
    form.name = '';
    this.divisionSearchForm.reset(form);
  }

  onAreaListControlChanged(division: DivisionModel): void {
    this.filterActive = false;
    let form = new DivisionSearchForm();
    form.code = '';
    form.name = division.name;
    this.divisionSearchForm.reset(form);
    this.divisionSelected.emit(division.id);
  }

}
