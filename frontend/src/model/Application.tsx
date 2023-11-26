export enum Status {
    NEW, IN_WORK, ADDITIONAL_REQUEST, REFINEMENT, FINISHED
}

export type Application = {
    id: number,
    product: string,
    amount: number,
    termMonths: number,
    interest: number, 
    creationDate: Date,
    status: Status
}