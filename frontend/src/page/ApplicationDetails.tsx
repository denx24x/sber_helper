import { Col, DsplL, DsplM, Row, TextBoxLabel, TextBoxSubTitle, TextBoxTitle } from "@salutejs/plasma-ui";
import React, { ReactNode } from "react";
import ApplicationCard from "../components/ApplicationCard";
import { Application, Status } from "../model/Application";
import { NavigateFunction, useLoaderData, useNavigate } from "react-router-dom";
import { JsxElement } from "typescript";
import { AccordionSummary, Typography, AccordionDetails, Accordion } from "@mui/material";
import TextBox from "../components/TextBox";
import { IconArrowDown, IconChevronDown } from "@salutejs/plasma-icons";



export async function ApplicationLoader(): Promise<Application> {
  const application = {
    id: 0,
    product: "Потребительский кредит",
    amount: 1000,
    term_months: 10,
    interest: 5,
    creation_date: new Date(Date.now()),
    status: Status.NEW
  }
  return application;
}


function ApplicationDetails(props: {}) {
  const application = useLoaderData() as Application;
  const navigate: NavigateFunction = useNavigate();
  return (
    <>
      <Col style={{
        alignSelf: 'center',
        width: "50%"
      }}>


        <Accordion>
          <AccordionSummary
            aria-controls="panel1a-content"
            id="panel1a-header"
            style={{ backgroundColor: "rgba(240, 240, 240, .5)", border: '1px solid rgba(0, 0, 0, .125)', marginTop: 15}}
          >
            <div style={{display: "flex", justifyContent: "space-between", alignItems: "center", width:"100%"}}>
            <DsplM style={{ fontSize: "1.5rem" }}>Общие данные по заявке</DsplM>
            <IconChevronDown/>
            </div>  
          </AccordionSummary>
          <AccordionDetails>
            <TextBox title="Номер заявки:" content={application.id.toString()} />
            <hr style={{color: "lightgray"}}/>
            <TextBox title="Продукт:" content={application.product.toString()} />
            <hr style={{color: "lightgray"}}/>
            <TextBox title="Размер:" content={application.amount.toString() + " рублей"} />
            <hr style={{color: "lightgray"}}/>
            <TextBox title="Длительность:" content={application.term_months.toString() + " месяцев"} />
            <hr style={{color: "lightgray"}}/>
            <TextBox title="Процентная ставка:" content={application.interest.toString() + "%"} />
            <hr style={{color: "lightgray"}}/>
            <TextBox title="Дата создания:" content={application.creation_date.toString()} />
            <hr style={{color: "lightgray"}}/>
            <TextBox title="Статус:" content={application.status.toString()} />
          </AccordionDetails>
        </Accordion>

      </Col>
    </>
  );
}

export default ApplicationDetails;

