import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthGuard } from './core/guards/auth.guard';
import { DashboardComponent } from './dashboard/dashboard.component';
import { PortalModule } from './portal/portal.module';

const routes: Routes = [
  {
    path: DashboardComponent.pathName,
    loadChildren: () => import('./dashboard/dashboard.module').then(mod => mod.DashboardModule),
    canActivate: [AuthGuard]
  },
  {
    path: PortalModule.pathName,
    loadChildren: () => import('./portal/portal.module').then(mod => mod.PortalModule),
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
