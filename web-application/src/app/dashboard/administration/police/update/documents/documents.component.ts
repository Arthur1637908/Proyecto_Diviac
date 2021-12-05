import { Component, Input, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { PageEvent } from '@angular/material/paginator';
import { ActivatedRoute } from '@angular/router';
import { IdentityDocumentModel } from 'src/app/core/models/identityDocument.model';
import { ParameterModel } from 'src/app/core/models/parameter.model';
import { CreatePoliceIdentityDocumentPostRequest, ListPoliceIdentityDocumentsGetRequest, ListPoliceIdentityDocumentsGetResponse } from 'src/app/core/models/services/police-service.model';
import { NotificationService } from 'src/app/core/services/notification.service';
import { ParametersService } from 'src/app/core/services/parameters.service';
import { PoliceService } from 'src/app/core/services/police.service';
import { CustomFormValidations } from 'src/app/core/utils/form-validations';
import { CreatePoliceIdentityDocumentForm } from '../../shared/models';
import { IDENTITY_DOCUMENT_CREATED, IDENTITY_DOCUMENT_DELETED, IDENTITY_DOCUMENT_UPDATED, DELETE_IDENTITY_DOCUMENT, SAVE_CHANGES_NOTIFY } from '../../shared/strings';
import { CONFIRM_ACTION, DELETE_SITUATION, CONFIRM_BUTTON } from '../../shared/strings';

@Component({
  selector: 'app-police-documents',
  templateUrl: './documents.component.html',
  styleUrls: []
})
export class DocumentsPoliceComponent implements OnInit {
  @Input() policeId: string = '';
  length = 0;
  pageSize = 10;
  pageSizeOptions: number[] = [2, 5, 10, 25, 100];
  currentPage = 1;
  currentIdentityDocumentId: string = '';
  displayedColumns: string[] = ['documentType', 'number', 'actions'];
  documentTypes: ParameterModel[] = [];
  updateState: boolean = false;
  documents: IdentityDocumentModel[] = [];
  documentPoliceForm = new FormGroup({
    documentTypeId: new FormControl('', [
      Validators.required
    ]),
    documentNumber: new FormControl('', [
      Validators.required,
      CustomFormValidations.validateOnlyNumbers
    ])
  })
  constructor(
    private route: ActivatedRoute,
    private parametersService: ParametersService,
    private policeService: PoliceService,
    private notificationService: NotificationService
  ) { }

  ngOnInit(): void {
    this.getDocumentTypes();
    this.getDocumentList(this.policeId);
  }

  getDocumentTypes(): void {
    this.parametersService
      .getParameters('TP02')
      .subscribe((response) => {
        this.documentTypes = response;
      });
  }

  getDocumentList(policeId: string): void {
    let listPoliceIdentityDocumentsGetRequest = new ListPoliceIdentityDocumentsGetRequest();
    listPoliceIdentityDocumentsGetRequest.policeId = policeId;
    listPoliceIdentityDocumentsGetRequest.currentPage = this.currentPage;
    listPoliceIdentityDocumentsGetRequest.pageSize = this.pageSize;

    this.getIdentityDocumentsService(listPoliceIdentityDocumentsGetRequest);
  }

  getIdentityDocumentsService(listPoliceIdentityDocumentsGetRequest: ListPoliceIdentityDocumentsGetRequest): void {
    this.policeService.getDocumentList(listPoliceIdentityDocumentsGetRequest)
      .subscribe((response: ListPoliceIdentityDocumentsGetResponse) => {
        console.log('response=>', response)
        this.documents = response.documents;
        // this.length = response.page.totalNumberOfItems;
      });
  }

  createDocument(documentForm: CreatePoliceIdentityDocumentForm): void {
    let policeIdentityDocument = new CreatePoliceIdentityDocumentPostRequest();
    policeIdentityDocument.documentNumber = documentForm.documentNumber;
    policeIdentityDocument.documentTypeId = documentForm.documentTypeId;
    policeIdentityDocument.policeId = this.policeId;

    this.policeService
      .createPoliceIdentityDocument(policeIdentityDocument)
      .subscribe(() => {
        this.notificationService.successNotification(IDENTITY_DOCUMENT_CREATED);
        this.resetForm();
        this.getDocumentList(this.policeId);
      });
  }

  confirmUpdateDocument(documentForm: CreatePoliceIdentityDocumentForm): void {
    this.notificationService.confirmNotification(
      CONFIRM_ACTION,
      SAVE_CHANGES_NOTIFY,
      CONFIRM_BUTTON,
      'warning'
    ).then((response) => {
      if (response.isConfirmed) {
        this.updateIdentityDocument(documentForm);
      }
    });
  }

  updateIdentityDocument(documentForm: CreatePoliceIdentityDocumentForm): void {
    let policeIdentityDocument = new CreatePoliceIdentityDocumentPostRequest();
    policeIdentityDocument.documentNumber = documentForm.documentNumber;
    policeIdentityDocument.documentTypeId = documentForm.documentTypeId;

    this.policeService
      .updateIdentityDocument(this.currentIdentityDocumentId, policeIdentityDocument)
      .subscribe(() => {
        this.notificationService.successNotification(IDENTITY_DOCUMENT_UPDATED);
        this.getDocumentList(this.policeId);
      });
  }

  resetForm(): void {
    this.documentPoliceForm.reset();
  }

  handlePageEvent(event: PageEvent): void {
    this.pageSize = event.pageSize;
    this.currentPage = event.pageIndex + 1;
    let listPoliceIdentityDocumentsGetRequest = new ListPoliceIdentityDocumentsGetRequest();
    listPoliceIdentityDocumentsGetRequest.policeId = this.policeId;
    listPoliceIdentityDocumentsGetRequest.currentPage = this.currentPage;
    listPoliceIdentityDocumentsGetRequest.pageSize = this.pageSize;
    this.getIdentityDocumentsService(listPoliceIdentityDocumentsGetRequest);
  }

  documentDetail(identityDocument: IdentityDocumentModel): void {
    console.log(identityDocument, 'identityDocument')
    let identityDocumentForm = new CreatePoliceIdentityDocumentForm();
    identityDocumentForm.documentNumber = identityDocument.documentNumber;
    identityDocumentForm.documentTypeId = identityDocument.documentType.id;
    this.updateState = true;
    this.currentIdentityDocumentId = identityDocument.id;
    this.setOriginalValues(identityDocumentForm);
  }

  setOriginalValues(identityDocumentForm: CreatePoliceIdentityDocumentForm): void {
    this.documentPoliceForm.setValue({
      documentNumber: identityDocumentForm.documentNumber,
      documentTypeId: identityDocumentForm.documentTypeId,
    });
  }

  confirmDeleteDocument(documentId: string): void {
    this.notificationService.confirmNotification(
      CONFIRM_ACTION,
      DELETE_IDENTITY_DOCUMENT,
      CONFIRM_BUTTON,
      'warning'
    ).then((response) => {
      if (response.isConfirmed) {
        this.deleteIdentityDocument(documentId);
      }
    });
  }

  deleteIdentityDocument(documentId: string): void {
    this.policeService
      .deleteIdentityDocument(documentId)
      .subscribe(() => {
        this.notificationService.successNotification(IDENTITY_DOCUMENT_DELETED);
        this.getDocumentList(this.policeId);
      });
  }

}
