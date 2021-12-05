import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClosedSourcesComponent } from './closed-sources/closed-sources.component';

import { HomeComponent } from './home/home.component';
import { PortalComponent } from './portal.component';

const routes: Routes = [
    {
        path: PortalComponent.pathName,
        component: PortalComponent,
        children: [
            {
                path: HomeComponent.pathName,
                component: HomeComponent
            },
            {
                path: ClosedSourcesComponent.pathName,
                component: ClosedSourcesComponent
            }
        ]
    },
    {
        path: '**',
        redirectTo: HomeComponent.pathName
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class PortalRoutingModule { }