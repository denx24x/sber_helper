import React, { JSXElementConstructor, ReactElement, ReactNode } from 'react';
import './App.css';

import { Button, Card, CardContent, Cell, CellDisclosure, CellIcon, CellListItem, Col, Container, DsplL, Header, HeaderRoot, Headline1, LineSkeleton, RectSkeleton, Row, TextBox, TextBoxBigTitle, TextBoxSubTitle, TextBoxTitle } from '@salutejs/plasma-ui';
import { background } from '@salutejs/plasma-tokens';
import {
  text, // Цвет текста
  gradient, // Градиент
} from '@salutejs/plasma-tokens';
import { IconBankCard, IconDevice, IconDownload, IconEvent, IconFolder, IconInfo, IconPersone } from '@salutejs/plasma-icons';


function App() {
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
            <Row>
            <Card style={{ width: '100%', marginLeft: '0.75rem', marginTop: "1rem"}}>
                <CardContent compact>
                    <Cell
                        content={<TextBoxBigTitle>Заявка №12415</TextBoxBigTitle>  as (ReactElement & string)}
                        contentRight={<span style={{ marginTop: 5 }}>Ожидает обработки</span>}
                    />
                    <CellListItem
                        contentLeft={
                            <CellIcon>
                                <IconInfo />
                            </CellIcon>
                        }
                        content={
                            <TextBox>
                                <TextBoxTitle>Потребительнский кредит</TextBoxTitle>
                                <TextBoxSubTitle>Заявлен 20.10.2023</TextBoxSubTitle>
                            </TextBox>  as (ReactElement & string)
                        }
                        contentRight={<CellDisclosure />}
                    />
                </CardContent>
            </Card>
            </Row>
            <Row>
            <Card style={{ width: '100%', marginLeft: '0.75rem', marginTop: "1rem"}}>
                <CardContent compact>
                    <Cell
                        content={<TextBoxBigTitle>Заявка №66415</TextBoxBigTitle>  as (ReactElement & string)}
                        contentRight={<span style={{ marginTop: 5 }}>Ожидает обработки</span>}
                    />
                    <CellListItem
                        contentLeft={
                            <CellIcon>
                                <IconInfo />
                            </CellIcon>
                        }
                        content={
                            <TextBox>
                                <TextBoxTitle>Потребительнский кредит</TextBoxTitle>
                                <TextBoxSubTitle>Заявлен 10.11.2023</TextBoxSubTitle>
                            </TextBox>  as (ReactElement & string)
                        }
                        contentRight={<CellDisclosure />}
                    />
                </CardContent>
            </Card>                 
            </Row>
            <Row>
                  
            <Card style={{ width: '100%', marginLeft: '0.75rem', marginTop: "1rem"}}>
                <CardContent compact>
                    <Cell
                        content={<TextBoxBigTitle>Заявка №432415</TextBoxBigTitle>  as (ReactElement & string)}
                        contentRight={<span style={{ marginTop: 5, color: 'orange' }}>На уточнении</span>}
                    />
                    <CellListItem
                        contentLeft={
                            <CellIcon>
                                <IconInfo />
                            </CellIcon>
                        }
                        content={
                            <TextBox>
                                <TextBoxTitle>Потребительнский кредит</TextBoxTitle>
                                <TextBoxSubTitle>Заявлен 20.10.2023</TextBoxSubTitle>
                            </TextBox>  as (ReactElement & string)
                        }
                        contentRight={<CellDisclosure />}
                    />
                </CardContent>
            </Card>      
            </Row>
            <Row>
            <Card style={{ width: '100%', marginLeft: '0.75rem', marginTop: "1rem"}}>
                <CardContent compact>
                    <Cell
                        content={<TextBoxBigTitle>Заявка №5315</TextBoxBigTitle>  as (ReactElement & string)}
                        contentRight={<span style={{ marginTop: 5, color: 'orange' }}>На уточнении</span>}
                    />
                    <CellListItem
                        contentLeft={
                            <CellIcon>
                                <IconInfo />
                            </CellIcon>
                        }
                        content={
                            <TextBox>
                                <TextBoxTitle>Потребительнский кредит</TextBoxTitle>
                                <TextBoxSubTitle>Заявлен 22.10.2023</TextBoxSubTitle>
                            </TextBox>  as (ReactElement & string)
                        }
                        contentRight={<CellDisclosure />}
                    />
                </CardContent>
            </Card>                 
            </Row>
            <Row>
            <Card style={{ width: '100%', marginLeft: '0.75rem', marginTop: "1rem"}}>
                <CardContent compact>
                    <Cell
                        content={<TextBoxBigTitle>Заявка №5315</TextBoxBigTitle>  as (ReactElement & string)}
                        contentRight={<span style={{ marginTop: 5, color: 'orange' }}>На уточнении</span>}
                    />
                    <CellListItem
                        contentLeft={
                            <CellIcon>
                                <IconInfo />
                            </CellIcon>
                        }
                        content={
                            <TextBox>
                                <TextBoxTitle>Потребительнский кредит</TextBoxTitle>
                                <TextBoxSubTitle>Заявлен 22.10.2023</TextBoxSubTitle>
                            </TextBox>  as (ReactElement & string)
                        }
                        contentRight={<CellDisclosure />}
                    />
                </CardContent>
            </Card>                 
            </Row>
            <Row>
            <Card style={{ width: '100%', marginLeft: '0.75rem', marginTop: "1rem"}}>
                <CardContent compact>
                    <Cell
                        content={<TextBoxBigTitle>Заявка №5315</TextBoxBigTitle>  as (ReactElement & string)}
                        contentRight={<span style={{ marginTop: 5, color: 'orange' }}>На уточнении</span>}
                    />
                    <CellListItem
                        contentLeft={
                            <CellIcon>
                                <IconInfo />
                            </CellIcon>
                        }
                        content={
                            <TextBox>
                                <TextBoxTitle>Потребительнский кредит</TextBoxTitle>
                                <TextBoxSubTitle>Заявлен 22.10.2023</TextBoxSubTitle>
                            </TextBox>  as (ReactElement & string)
                        }
                        contentRight={<CellDisclosure />}
                    />
                </CardContent>
            </Card>                 
            </Row>
          </Col>
        </Container>    
    </>
  );
}

export default App;
 