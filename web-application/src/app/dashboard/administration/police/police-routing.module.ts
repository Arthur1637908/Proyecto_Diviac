import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreatePoliceComponent } from './create/create.component';
import { ListPoliceComponent } from './list/list.component';
import { UpdatePoliceComponent } from './update/update.component';
import { PoliceComponent } from './police.component';

const routes: Routes = [
    {
        path: '',
        component: PoliceComponent,
        children: [
            {
                path: '',
                component: ListPoliceComponent
            },
            {
                path: CreatePoliceComponent.pathName,
                component: CreatePoliceComponent
            },
            {
                path: UpdatePoliceComponent.pathName,
                component: UpdatePoliceComponent
            }
        ]
    }
];


@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class PoliceRoutingModule { }