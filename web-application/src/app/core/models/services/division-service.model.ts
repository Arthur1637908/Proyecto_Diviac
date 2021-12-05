import { DivisionModel } from "../division.model";
import { PageModel } from "../page.model";

export class DivisionGetResponse {
    page!: PageModel;
    divisions!: DivisionModel[];
}

export class DivisionGetRequest {
    code!: string;
    name!: string;
    currentPage!: number;
    pageSize!: number;
}