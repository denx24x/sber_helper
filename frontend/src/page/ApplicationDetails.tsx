import { Button, Col, DsplL, DsplM, Row, TextBoxLabel, TextBoxSubTitle, TextBoxTitle } from "@salutejs/plasma-ui";
import React, { ReactNode } from "react";
import ApplicationCard from "../components/ApplicationCard";
import { Application, Status } from "../model/Application";
import { NavigateFunction, useLoaderData, useNavigate } from "react-router-dom";
import { JsxElement } from "typescript";
import { AccordionSummary, Typography, AccordionDetails, Accordion } from "@mui/material";
import TextBox from "../components/TextBox";
import { IconArrowDown, IconChevronDown } from "@salutejs/plasma-icons";
import {
  text, // Цвет текста
  background, // Цвет подложки
  gradient,
  gradientDevice, // Градиент
} from '@salutejs/plasma-tokens';
import { Form } from "../model/Form";
import { BlockNoteView, useBlockNote } from "@blocknote/react";

export async function ApplicationLoader(params: any): Promise<Data> {
  return Promise.all([
    fetch("/v1/applications/" + params.params.applicationId)
      .then(response => response.json()),
    fetch("/v1/applications/" + params.params.applicationId + "/forms")
      .then(response => response.json())]
  ).then(
    ([application, forms]: [Application, Form[]]) => {
      return {
        application: application,
        forms: forms
      }
    }
  );
}

type Data = {
  application: Application,
  forms: Form[]
}

function ApplicationDetails(props: {}) {
  const data = useLoaderData() as Data;
  const navigate: NavigateFunction = useNavigate();



  return (
    <>
      <Col style={{
        alignSelf: 'center',
        width: "45%"
      }}>


        <Accordion>
          <AccordionSummary
            aria-controls="panel1a-content"
            id="panel1a-header"
            style={{ backgroundColor: "rgba(240, 240, 240, .5)", border: '1px solid rgba(0, 0, 0, .125)', marginTop: 15 }}
          >
            <div style={{ display: "flex", justifyContent: "space-between", alignItems: "center", width: "100%" }}>
              <DsplM style={{ fontSize: "1.5rem" }}>Общие данные по заявке</DsplM>
              <IconChevronDown color="black" />
            </div>
          </AccordionSummary>
          <AccordionDetails style={{ background: text }}>
            <TextBox title="Номер заявки:" content={data.application.id.toString()} />
            <hr style={{ color: "lightgray" }} />
            <TextBox title="Продукт:" content={data.application.product.toString()} />
            <hr style={{ color: "lightgray" }} />
            <TextBox title="Размер:" content={data.application.amount.toString() + " рублей"} />
            <hr style={{ color: "lightgray" }} />
            <TextBox title="Длительность:" content={data.application.termMonths.toString() + " месяцев"} />
            <hr style={{ color: "lightgray" }} />
            <TextBox title="Процентная ставка:" content={data.application.interest.toString() + "%"} />
            <hr style={{ color: "lightgray" }} />
            <TextBox title="Дата создания:" content={data.application.creationDate.toString()} />
            <hr style={{ color: "lightgray" }} />
            <TextBox title="Статус:" content={data.application.status.toString()} />
          </AccordionDetails>
        </Accordion>

        {
          data.forms.map((form: Form) =>
            <>
              <Accordion>
                <AccordionSummary
                  aria-controls="panel1a-content"
                  id="panel1a-header"
                  style={{ backgroundColor: "rgba(240, 240, 240, .5)", border: '1px solid rgba(0, 0, 0, .125)', marginTop: 15 }}
                >
                  <div style={{ display: "flex", justifyContent: "space-between", alignItems: "center", width: "100%" }}>
                    <DsplM style={{ fontSize: "1.5rem" }}>Анкета {form.fullName}</DsplM>
                    <IconChevronDown color="black" />
                  </div>
                </AccordionSummary>
                <AccordionDetails style={{ background: text }}>
                  <TextBox title="Номер анкеты:" content={form.id.toString()} />
                  <hr style={{ color: "lightgray" }} />
                  <TextBox title="ФИО:" content={form.fullName.toString()} />
                  <hr style={{ color: "lightgray" }} />
                  <TextBox title="Дата рождения:" content={form.birthday.toString()} />
                  <hr style={{ color: "lightgray" }} />
                  <TextBox title="Адрес регистрации:" content={form.registrationAddress.toString()} />
                  <hr style={{ color: "lightgray" }} />
                  <TextBox title="Адрес пребывания:" content={form.residentialAddress.toString()} />
                  <hr style={{ color: "lightgray" }} />
                  <TextBox title="Семейное положение:" content={form.materialStatus.toString()} />
                  <hr style={{ color: "lightgray" }} />
                  <TextBox title="Дети:" content={form.hasChildren.toString()} />
                  <hr style={{ color: "lightgray" }} />
                  <TextBox title="Место работы:" content={form.workPlace.toString()} />
                  <hr style={{ color: "lightgray" }} />
                  <TextBox title="Опыт работы:" content={form.workingExperienceInMonth.toString() + " месяцев"} />
                  <hr style={{ color: "lightgray" }} />
                  <TextBox title="Зарплата:" content={form.salary.toString()} />
                  <hr style={{ color: "lightgray" }} />
                  <TextBox title="Дополнительный доход:" content={form.additionalSalary.toString()} />
                  <hr style={{ color: "lightgray" }} />
                  <TextBox title="Источник дополнительного дохода:" content={form.sourceAdditionalSalary.toString()} />
                </AccordionDetails>
              </Accordion>
              {form.bankAccountInfo ? (
                <Accordion>
                  <AccordionSummary
                    aria-controls="panel1a-content"
                    id="panel1a-header"
                    style={{ backgroundColor: "rgba(240, 240, 240, .5)", border: '1px solid rgba(0, 0, 0, .125)', marginTop: 15 }}
                  >
                    <div style={{ display: "flex", justifyContent: "space-between", alignItems: "center", width: "100%" }}>
                      <DsplM style={{ fontSize: "1.5rem" }}>Банковский счет {form.fullName}</DsplM>
                      <IconChevronDown color="black" />
                    </div>
                  </AccordionSummary>
                  <AccordionDetails style={{ background: text }}>
                    <TextBox title="Размер сбережений:" content={form.bankAccountInfo.amount.toString()} />
                    <hr style={{ color: "lightgray" }} />
                    <TextBox title="Категория:" content={form.bankAccountInfo.category.toString()} />

                  </AccordionDetails>
                </Accordion>
              ) : (
                <></>
              )
              }
            </>
          )
        }
        <div style={{display: "flex", flexDirection: "row", justifyContent: "space-between", marginTop: "1rem"}}>
          <Button style={{background: "red", width: "100%", marginRight: 10}} title="">Отказать</Button>
          <Button style={{background: "darkorange", width: "100%", marginLeft: 5, marginRight: 5}} title="">Уточнить данные</Button>
          <Button style={{background: "green", width: "100%", marginLeft:10}} content="">Согласовать</Button>
        </div>
      </Col>
    </>
  );
}

export default ApplicationDetails;

