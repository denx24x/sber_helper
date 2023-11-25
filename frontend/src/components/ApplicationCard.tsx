import { IconInfo } from "@salutejs/plasma-icons"
import { Card, CardContent, Cell, TextBoxBigTitle, CellListItem, CellIcon, TextBox, TextBoxTitle, TextBoxSubTitle, CellDisclosure, Button } from "@salutejs/plasma-ui"
import { Console } from "console"
import { ReactElement } from "react"
import "./ApplicationCard.css"
import React from "react"
import { Application } from "../model/Application"

export type ApplicationCardProps = {
    application: Application
}

type State = {

}

class ApplicationCard extends React.Component<ApplicationCardProps, State> {
    public constructor(props: ApplicationCardProps) {
        super(props);
        this.state = {}
    }

    private openApplication = () => {
        
    }

    public render() {
        return (
            <>
                <Button className="card" stretch view="clear" onClick={() => this.openApplication()}>
                    <Card style={{ width: "100%" }} >
                        <CardContent compact>
                            <Cell
                                content={<TextBoxBigTitle>Заявка №{this.props.application.id.toString()}</TextBoxBigTitle> as (ReactElement & string)}
                                contentRight={<span style={{ marginTop: 5 }}>{this.props.application.status}</span>}
                            />
                            <CellListItem
                                contentLeft={
                                    <CellIcon>
                                        <IconInfo />
                                    </CellIcon>
                                }
                                content={
                                    <TextBox>
                                        <TextBoxTitle>{this.props.application.product}</TextBoxTitle>
                                        <TextBoxSubTitle>Заявлен {this.props.application.creation_date.toString()}</TextBoxSubTitle>
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
}

export default ApplicationCard