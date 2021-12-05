import { Component, Input, OnInit, ViewChild } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { DateAdapter, MAT_DATE_FORMATS } from '@angular/material/core';
import { ParameterModel } from 'src/app/core/models/parameter.model';
import { PoliceSituationModel } from 'src/app/core/models/policeSituation.model';
import { CreatePoliceSituationPostRequest, ListPoliceSituationsGetRequest, ListPoliceSituationsGetResponde } from 'src/app/core/models/services/police-service.model';
import { ParametersService } from 'src/app/core/services/parameters.service';
import { PoliceService } from 'src/app/core/services/police.service';
import { AppDateAdapter, APP_DATE_FORMATS } from 'src/app/core/utils/format-datepicker';
import { CreatePoliceSituationForm } from '../../shared/models';
import * as moment from 'moment';
import { NotificationService } from 'src/app/core/services/notification.service';
import { SAVE_CHANGES_NOTIFY, SITUATION_CREATED, SITUATION_DELETED, SITUATION_UPDATED } from '../../shared/strings';
import { CONFIRM_ACTION, DELETE_SITUATION, CONFIRM_BUTTON } from '../../shared/strings';
import { PageEvent } from '@angular/material/paginator';
import { DivisionDropdownPaginationComponent } from 'src/app/dashboard/components/division-dropdown-pagination/division-dropdown-pagination.component';
import { DivisionModel } from 'src/app/core/models/division.model';
export default moment;

@Component({
  selector: 'app-police-situation',
  templateUrl: './situation.component.html',
  styleUrls: [],
  providers: [
    { provide: DateAdapter, useClass: AppDateAdapter },
    { provide: MAT_DATE_FORMATS, useValue: APP_DATE_FORMATS },
  ]
})
export class SituationPoliceComponent implements OnInit {
  @ViewChild(DivisionDropdownPaginationComponent)
  divisionDropdownPaginationComponent!: DivisionDropdownPaginationComponent;
  @Input() policeId: string = '';
  currentSituationId: string = '';
  currentDocumentName: string = '';
  length = 0;
  pageSize = 10;
  pageSizeOptions: number[] = [2, 5, 10, 25, 100];
  currentPage = 1;
  displayedColumns: string[] = ['division', 'situation', 'startDate', 'endDate', 'actions'];
  situations: PoliceSituationModel[] = [];
  currentDivisionIdSelected: string = '';
  currentDivisionName: string = '';
  situationTypes: ParameterModel[] = [];
  updateState: boolean = false;
  editDocument: boolean = true;
  situationPoliceForm = new FormGroup({
    situationId: new FormControl('', [
      Validators.required
    ]),
    startDate: new FormControl('', [
      Validators.required
    ]),
    endDate: new FormControl('', [
      Validators.required
    ]),
    document: new FormControl('', [
      Validators.required
    ]),
  })
  constructor(
    private parametersService: ParametersService,
    private policeService: PoliceService,
    private notificationService: NotificationService
  ) { }

  ngOnInit(): void {
    this.getSituationTypes();
  }

  getSituationTypes(): void {
    this.parametersService
      .getParameters('TP03')
      .subscribe((response) => {
        this.situationTypes = response;
      });
    this.getSituations(this.policeId);
  }

  getSituations(policeId: string): void {
    let listPoliceSituationsGetRequest = new ListPoliceSituationsGetRequest();
    listPoliceSituationsGetRequest.policeId = policeId;
    listPoliceSituationsGetRequest.currentPage = this.currentPage;
    listPoliceSituationsGetRequest.pageSize = this.pageSize;

    this.getSituationsService(listPoliceSituationsGetRequest);
  }

  getSituationsService(listPoliceSituationsGetRequest: ListPoliceSituationsGetRequest): void {
    this.policeService
      .getSituations(listPoliceSituationsGetRequest)
      .subscribe((response: ListPoliceSituationsGetResponde) => {
        this.situations = response.situations;
        this.length = response.page.totalNumberOfItems;
      });
  }

  createSituation(situationForm: CreatePoliceSituationForm): void {
    let policeSituation = new CreatePoliceSituationPostRequest();
    policeSituation.divisionId = this.currentDivisionIdSelected;
    policeSituation.policeId = this.policeId;
    policeSituation.situationTypeId = parseInt(situationForm.situationId);
    policeSituation.startDate = moment(situationForm.startDate).format('DD/MM/YYYY');
    policeSituation.endDate = moment(situationForm.endDate).format('DD/MM/YYYY');
    policeSituation.document = situationForm.document.files[0];

    const polciceSituationFormData = new FormData();

    for (const [key, value] of Object.entries(policeSituation)) {
      polciceSituationFormData.append(key, value);
    }

    this.policeService
      .createPoliceSituation(polciceSituationFormData)
      .subscribe(() => {
        this.notificationService.successNotification(SITUATION_CREATED);
        this.resetForm();
        this.getSituations(this.policeId);
      });
  }

  resetForm(): void {
    let resetForm = new CreatePoliceSituationForm();
    resetForm.document = '';
    resetForm.endDate = '';
    resetForm.startDate = '';
    resetForm.situationId = '';
    this.divisionDropdownPaginationComponent.resetPagination();
    this.editDocument = true;
    this.situationPoliceForm.reset();
  }

  setOriginalValues(situationForm: CreatePoliceSituationForm, division: DivisionModel): void {
    const endDate = situationForm.endDate.split("/");
    const endDateObject = new Date(+endDate[2], parseInt(endDate[1]) - 1, +endDate[0]);
    const startDate = situationForm.startDate.split("/");
    const startDateObject = new Date(+startDate[2], parseInt(startDate[1]) - 1, +startDate[0]);
    this.situationPoliceForm.setValue({
      situationId: situationForm.situationId,
      startDate: startDateObject,
      endDate: endDateObject,
      document: situationForm.document
    });
    this.divisionDropdownPaginationComponent.onAreaListControlChanged(division);
  }

  divisionSelected(divisionId: string): void {
    this.currentDivisionIdSelected = divisionId;
  }

  confirmDeleteSituation(situationId: string): void {
    this.notificationService.confirmNotification(
      CONFIRM_ACTION,
      DELETE_SITUATION,
      CONFIRM_BUTTON,
      'warning'
    ).then((response) => {
      if (response.isConfirmed) {
        this.deleteSituation(situationId);
      }
    });
  }

  deleteSituation(situationId: string): void {
    this.policeService
      .deleteSituation(situationId)
      .subscribe(() => {
        this.notificationService.successNotification(SITUATION_DELETED);
        this.getSituations(this.policeId);
      });
  }

  situationDetail(situation: PoliceSituationModel): void {
    let situationForm = new CreatePoliceSituationForm();
    situationForm.document = situation.documentName;
    situationForm.endDate = situation.endDate;
    situationForm.situationId = situation.situationType.id;
    situationForm.startDate = situation.startDate;
    let division = new DivisionModel();
    division.id = situation.division.id;
    division.name = situation.division.name;
    this.currentSituationId = situation.id;
    this.currentDocumentName = situation.documentName;
    this.updateState = true;
    this.editDocument = false;
    this.currentDivisionIdSelected = situation.division.id;
    this.setOriginalValues(situationForm, division);
  }

  updateDocument(): void {
    this.editDocument = true;
  }

  handlePageEvent(event: PageEvent): void {
    this.pageSize = event.pageSize;
    this.currentPage = event.pageIndex + 1;
    let listPoliceSituationsGetRequest = new ListPoliceSituationsGetRequest();
    listPoliceSituationsGetRequest.policeId = this.policeId;
    listPoliceSituationsGetRequest.currentPage = this.currentPage;
    listPoliceSituationsGetRequest.pageSize = this.pageSize;
    this.getSituationsService(listPoliceSituationsGetRequest);
  }

  confirmUpdateSituation(situationForm: CreatePoliceSituationForm): void {
    this.notificationService.confirmNotification(
      CONFIRM_ACTION,
      SAVE_CHANGES_NOTIFY,
      CONFIRM_BUTTON,
      'warning'
    ).then((response) => {
      if (response.isConfirmed) {
        this.updateSituation(situationForm);
      }
    });
  }

  updateSituation(situationForm: CreatePoliceSituationForm): void {
    let policeSituation = new CreatePoliceSituationPostRequest();
    policeSituation.divisionId = this.currentDivisionIdSelected;
    policeSituation.situationTypeId = parseInt(situationForm.situationId);
    policeSituation.startDate = moment(situationForm.startDate).format('DD/MM/YYYY');
    policeSituation.endDate = moment(situationForm.endDate).format('DD/MM/YYYY');
    policeSituation.document = situationForm.document.files[0];

    const polciceSituationFormData = new FormData();

    for (const [key, value] of Object.entries(policeSituation)) {
      polciceSituationFormData.append(key, value);
    }

    this.policeService
      .updateSituation(this.currentSituationId, polciceSituationFormData)
      .subscribe((response: PoliceSituationModel) => {
        this.currentDocumentName = response.documentName;
        this.editDocument = false;
        this.notificationService.successNotification(SITUATION_UPDATED);
        this.getSituations(this.policeId);
      });
  }

}
