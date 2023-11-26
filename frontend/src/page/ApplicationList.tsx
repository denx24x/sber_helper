import React, { JSXElementConstructor, ReactElement, ReactNode, useState } from 'react';
import './ApplicationList.css';

import { Button, Card, CardContent, Cell, CellDisclosure, CellIcon, CellListItem, Col, Container, DsplL, Header, HeaderRoot, Headline1, LineSkeleton, RectSkeleton, Row, Spinner, TextBox, TextBoxBigTitle, TextBoxSubTitle, TextBoxTitle, TextL } from '@salutejs/plasma-ui';
import { background, voicePhraseGradient } from '@salutejs/plasma-tokens';
import {
  text, // Цвет текста
  gradient, // Градиент
} from '@salutejs/plasma-tokens';
import { IconBankCard, IconDevice, IconDownload, IconEvent, IconFolder, IconInfo, IconPersone } from '@salutejs/plasma-icons';
import ApplicationCard from '../components/ApplicationCard';
import { Application, Status } from '../model/Application';
import { Link, useLoaderData, useNavigate } from 'react-router-dom';

export async function ApplicationsLoader()  : Promise<Application[]> {
  const applications = [{
    id: 0,
    product: "Потребительский кредит",
    amount: 1000,
    term_months: 10,
    interest: 5, 
    creation_date: new Date(Date.now()),
    status: Status.NEW
  },
  {
    id: 0,
    product: "Потребительский кредит",
    amount: 1000,
    term_months: 10,
    interest: 5, 
    creation_date: new Date(Date.now()),
    status: Status.NEW
  },{
    id: 0,
    product: "Потребительский кредит",
    amount: 1000,
    term_months: 10,
    interest: 5, 
    creation_date: new Date(Date.now()),
    status: Status.NEW
  },{
    id: 0,
    product: "Потребительский кредит",
    amount: 1000,
    term_months: 10,
    interest: 5, 
    creation_date: new Date(Date.now()),
    status: Status.NEW
  },{
    id: 0,
    product: "Потребительский кредит",
    amount: 1000,
    term_months: 10,
    interest: 5, 
    creation_date: new Date(Date.now()),
    status: Status.NEW
  },{
    id: 0,
    product: "Потребительский кредит",
    amount: 1000,
    term_months: 10,
    interest: 5, 
    creation_date: new Date(Date.now()),
    status: Status.NEW
  },{
    id: 0,
    product: "Потребительский кредит",
    amount: 1000,
    term_months: 10,
    interest: 5, 
    creation_date: new Date(Date.now()),
    status: Status.NEW
  },
  {
    id: 0,
    product: "Потребительский кредит",
    amount: 1000,
    term_months: 10,
    interest: 5, 
    creation_date: new Date(Date.now()),
    status: Status.NEW
  }]
  return applications;
}

function ApplicationList(props : {}) {
    const applications = useLoaderData() as Application[];
    const navigate = useNavigate();

    return (
      <>
      {applications.length? (
          <Col style={{
            alignSelf: 'center',
            width: "50%"
          }}>
            {
              applications.map((application : Application) => 
                  <Row style={{paddingTop: "6rem"}}>
                    <ApplicationCard application={application} navigate={navigate} />
                  </Row>
                 )
            }
          </Col>
      ) : (
        <Spinner />
      )} 

      </>
    );
}

export default ApplicationList;

