import { Component } from '@angular/core';
import { Subscription } from 'rxjs';
import { GenericService } from './core/services/generic.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'diviac-frontend';

  public loading: boolean = false;
  private countdownEndRef: Subscription = new Subscription();

  constructor(
    private genericService: GenericService
  ) {
  }

  ngOnInit(): void {}

  ngAfterViewInit() {
    this.countdownEndRef = this.genericService.countdownEnd$.subscribe(data => setTimeout(() => this.loading = data, 0));
  }
}
