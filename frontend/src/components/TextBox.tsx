import { IconInfo } from "@salutejs/plasma-icons"
import { Card, CardContent, Cell, TextBoxBigTitle, CellListItem, CellIcon, TextBoxTitle, TextBoxSubTitle, CellDisclosure, Button, TextBoxLabel } from "@salutejs/plasma-ui"
import { Console } from "console"
import { ReactElement } from "react"
import "./ApplicationCard.css"
import React from "react"
import { Application } from "../model/Application"
import { NavigateFunction, Navigation, redirect, useNavigate, useNavigation } from "react-router-dom"
import {
    text, // Цвет текста
    background, // Цвет подложки
    gradient,
    gradientDevice, // Градиент
} from '@salutejs/plasma-tokens';

export type ApplicationCardProps = {
    application: Application
}

type Props = {
    title: string,
    content: string
}

function TextBox(props : Props) {
    return (
            <>
                <div style={{display: "flex", justifyContent: "space-between", alignItems: "center", width:"100%", marginTop: 5}}>
                    <TextBoxTitle style={{color: background}}>{props.title}</TextBoxTitle>
                    <TextBoxTitle style={{color: background}} >{props.content}</TextBoxTitle>
                </div>
            </>
        )
    }

export default TextBox