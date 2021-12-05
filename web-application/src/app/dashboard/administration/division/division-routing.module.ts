import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateDivisionComponent } from './create/create.component';

import { DivisionComponent } from './division.component';
import { ListDivisionComponent } from './list/list.component';
import { UpdateDivisionComponent } from './update/update.component';

const routes: Routes = [
    {
        path: '',
        component: DivisionComponent,
        children: [
            {
                path: '',
                component: ListDivisionComponent
            },
            {
                path: DivisionComponent.pathName,
                children: [
                    {
                        path: CreateDivisionComponent.pathName,
                        component: CreateDivisionComponent
                    },
                    {
                        path: UpdateDivisionComponent.pathName,
                        component: UpdateDivisionComponent
                    }
                ]
            }
        ]
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class DivisionRoutingModule { }