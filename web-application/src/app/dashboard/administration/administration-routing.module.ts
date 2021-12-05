import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdministrationComponent } from './administration.component';

import { PoliceComponent } from './police/police.component';

const routes: Routes = [
    {
        path: '',
        component: AdministrationComponent,
        children: [
            {
                path: '',
                loadChildren: () => import('./division/division.module').then(mod => mod.DivisionModule)
            },
            {
                path: PoliceComponent.pathName,
                loadChildren: () => import('./police/police.module').then(mod => mod.PoliceModule)
            },
        ]
    },
    {
        path: '**',
        redirectTo: ''
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class AdministrationRoutingModule { }