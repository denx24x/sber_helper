import { IconInfo } from "@salutejs/plasma-icons"
import { Card, CardContent, Cell, TextBoxBigTitle, CellListItem, CellIcon, TextBox, TextBoxTitle, TextBoxSubTitle, CellDisclosure, Button } from "@salutejs/plasma-ui"
import { Console } from "console"
import { ReactElement } from "react"
import "./ApplicationCard.css"
import React from "react"
import { Application } from "../model/Application"
import { NavigateFunction, Navigation, redirect, useNavigate, useNavigation } from "react-router-dom"

export type ApplicationCardProps = {
    application: Application
}

type Props = {
    navigate: NavigateFunction
    application: Application
}

function ApplicationCard(props : Props) {
    
    return (
            <>
                <Button className="card" stretch view="clear" onClick={() => props.navigate("/application/" + props.application.id.toString())}>
                    <Card style={{ width: "100%" }} >
                        <CardContent compact>
                            <Cell
                                content={<TextBoxBigTitle>Заявка №{props.application.id.toString()}</TextBoxBigTitle> as (ReactElement & string)}
                                contentRight={<span style={{ marginTop: 5 }}>{props.application.status}</span>}
                            />  
                            <CellListItem
                                contentLeft={
                                    <CellIcon>
                                            <IconInfo />
                                    </CellIcon>
                                }
                                content={
                                    <TextBox>
                                        <TextBoxTitle>{props.application.product}</TextBoxTitle>
                                        <TextBoxSubTitle>Заявлен {props.application.creation_date.toString()}</TextBoxSubTitle>
                                    </TextBox> as (ReactElement & string)
                                }
                                contentRight={<CellDisclosure />}
                            />
                        </CardContent>
                    </Card>
                </Button>
            </>
        )
    }

export default ApplicationCard