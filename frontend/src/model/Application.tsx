export enum Status {
    NEW, WAITING, READY
}

export type Savings = {
    amount: number,
    category: string
}

export type Application = {
    id: number,
    status: Status,
    fullname : string,
    birthday : Date,
    passportData : string, 
    registrationAddress : string,
    residentialAddress : string,
    maritalStatus : string,
    hasChildren : boolean,
    workPlace : string,
    workExperience : number,
    workPosition : string,
    salary : number,
    additionalSalary : number,
    approvedAdditionalSalary : boolean,
    sourceAdditionalSalary : string,
    savesOnBankAccount : Savings[]
}