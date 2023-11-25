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
import { Application } from './model/Application';


type State = {
  applications: Application[]
}

class App extends React.Component<{}, State> {
  public constructor(props: {}){
    super(props)
    this.state = {
      applications: [{}, {}, {}]
    }

  }

  private requestApplications(){

  }

  public render() {
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
              this.state.applications.map(application => <ApplicationCard number="123" status="Ожидает обработки" product="Потребительский кредит" date="05.10.22" />)
            }
          </Col>
        </Container>
      </>
    );
  }
}

export default App;

