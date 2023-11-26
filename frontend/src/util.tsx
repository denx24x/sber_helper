import { Application } from "./model/Application";

export function parseApplication(data : string) : Application {
    return JSON.parse(data);
}