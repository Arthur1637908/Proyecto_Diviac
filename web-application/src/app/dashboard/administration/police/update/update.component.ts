import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NotificationService } from 'src/app/core/services/notification.service';
import { PoliceService } from 'src/app/core/services/police.service';
import { CONFIRM_ACTION, CONFIRM_BUTTON, DELETE_POLICE, POLICE_DELETED } from '../shared/strings';

@Component({
  selector: 'app-police-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.scss']
})
export class UpdatePoliceComponent implements OnInit {
  static pathName: string = ':id';
  policeId: string = '';
  constructor(
    private route: ActivatedRoute,
    private notificationService: NotificationService,
    private policeService: PoliceService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.policeId = params['id'];
    });
  }

  confirmDeletePolice(): void {
    this.notificationService.confirmNotification(
      CONFIRM_ACTION,
      DELETE_POLICE,
      CONFIRM_BUTTON,
      'warning'
    ).then((response) => {
      if (response.isConfirmed) {
        this.deletePolice(this.policeId);
      }
    });
  }

  deletePolice(policeId: string): void {
    this.policeService
      .deletePoliceById(policeId)
      .subscribe(() => {
        this.notificationService.successNotification(POLICE_DELETED);
        this.router.navigate([`/dashboard/efectivo`]);
      });
  }
}
