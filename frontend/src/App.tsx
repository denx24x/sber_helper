import React, { JSXElementConstructor, ReactElement, ReactNode } from 'react';
import './App.css';

import { Button, Card, CardContent, Cell, CellDisclosure, CellIcon, CellListItem, Col, Container, DsplL, Header, HeaderRoot, Headline1, LineSkeleton, RectSkeleton, Row, TextBox, TextBoxBigTitle, TextBoxSubTitle, TextBoxTitle, TextL } from '@salutejs/plasma-ui';
import { background, voicePhraseGradient } from '@salutejs/plasma-tokens';
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
      },
      {
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
    }

  }

  private requestApplications = () => {

  }

  public render() : ReactNode {
    return (
      <>
        <Headline1 style={{
          paddingLeft: 40,
          paddingTop: 20,
          paddingBottom: 20,
          borderRadius: 20,
          fontSize: "2rem",
          color: "white",
          opacity: 0.7,
          backgroundImage: voicePhraseGradient
        }}>
          <TextL>СБЕР помощник</TextL>
        </Headline1>
        <Container>
          <Col style={{
            alignSelf: 'center',
            width: "50%"
          }}>
            {
              this.state.applications.map(application => 
                  <Row style={{paddingTop: "6rem"}}>
                    <ApplicationCard application={application} />
                  </Row>
                 )
            }
          </Col>
        </Container>
      </>
    ) as ReactNode;
  }
}

export default App;

