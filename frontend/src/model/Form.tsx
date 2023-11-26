export type Form = {
    "id": number,
    "applicationId": number,
    "fullName": string,
    "birthday": Date,
    "passportData": string,
    "registrationAddress": string,
    "residentialAddress": string,
    "materialStatus": string,
    "hasChildren": boolean,
    "workPlace": string,
    "workingExperienceInMonth": number,
    "workPosition": string,
    "salary": number,
    "additionalSalary": number,
    "sourceAdditionalSalary": string,
    "bankAccountInfo": {
        "id": number,
        "amount": number,
        "category": string,
        "creationDate": Date,
        "updateDate": Date
      },
    "creationDate": Date,
    "updateDate": Date
}