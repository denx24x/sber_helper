import React, { JSXElementConstructor, ReactElement, ReactNode } from 'react';
import './App.css';

import { Button, Card, CardContent, Cell, CellDisclosure, CellIcon, CellListItem, Col, Container, DsplL, Header, HeaderRoot, Headline1, LineSkeleton, RectSkeleton, Row, TextBox, TextBoxBigTitle, TextBoxSubTitle, TextBoxTitle } from '@salutejs/plasma-ui';
import { background } from '@salutejs/plasma-tokens';
import {
  text, // Цвет текста
  gradient, // Градиент
} from '@salutejs/plasma-tokens';
import { IconBankCard, IconDevice, IconDownload, IconEvent, IconFolder, IconInfo, IconPersone } from '@salutejs/plasma-icons';
import ApplicationCard from './components/ApplicationCard';
import { Application, Status } from './model/Application';


type State = {
  applications: Application[]
}

class App extends React.Component<{}, State> {
  public constructor(props: {}){
    super(props)
    this.state = {
      applications: [{
        id: 0,
        product: "Потребительский кредит",
        amount: 1000,
        term_months: 10,
        interest: 5, 
        creation_date: new Date(Date.now()),
        status: Status.NEW
      }]
    }

  }

  private requestApplications(){

  }

  public render() : ReactNode {
    return (
      <>
        <Headline1 style={{
          paddingLeft: 20,
          paddingTop: 20,
          paddingBottom: 20,
          fontSize: "2rem",
          color: "black",
          background: 'lightgreen'
        }}>
          <DsplL>Sber помощник</DsplL>
        </Headline1>
        <Container>
          <Col style={{
            alignSelf: 'center',
            width: "50%"
          }}>
            {
              this.state.applications.map(application => <ApplicationCard number={application.id.toString()} status={application.status.toString()} product={application.product} date={application.creation_date.toUTCString()} />)
            }
          </Col>
        </Container>
      </>
    ) as ReactNode;
  }
}

export default App;

