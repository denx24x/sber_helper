export enum Status {
    NEW, IN_WORK, ADDITIONAL_REQUEST, REFINEMENT, FINISHED
}

export type Application = {
    id: number,
    product: string,
    amount: number,
    term_months: number,
    interest: number, 
    creation_date: Date,
    status: Status
}