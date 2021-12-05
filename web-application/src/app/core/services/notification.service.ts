import { Injectable } from '@angular/core';
import Swal, { SweetAlertResult, SweetAlertIcon } from 'sweetalert2';

@Injectable({
  providedIn: 'root'
})
export class NotificationService {

  private confirmButtonColor = '#3f51b5';
  private cancelButtonColor = '#f44336';

  constructor() { }

  successNotification(notificationMessage: string): Promise<SweetAlertResult<any>> {
    return Swal.fire({
      title: '¡Operación exitosa!',
      text: notificationMessage,
      focusConfirm: true,
      confirmButtonText: 'Aceptar',
      confirmButtonColor: this.confirmButtonColor,
      confirmButtonAriaLabel: '',
      icon: 'success',
      heightAuto: false
    });
  };

  errorNotification(notificationMessage: string): void {
    Swal.fire({
      icon: 'error',
      title: 'Oops...',
      text: notificationMessage,
      heightAuto: false
    })
  }

  confirmNotification(
    title: string,
    text: string,
    confirmButtonText: string,
    icon: SweetAlertIcon): Promise<SweetAlertResult<any>> {
    return Swal.fire({
      title,
      text,
      icon,
      showCancelButton: true,
      confirmButtonColor: this.confirmButtonColor,
      cancelButtonColor: this.cancelButtonColor,
      confirmButtonText,
      heightAuto: false
    })
  }

}