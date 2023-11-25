import { IconInfo } from "@salutejs/plasma-icons"
import { Card, CardContent, Cell, TextBoxBigTitle, CellListItem, CellIcon, TextBox, TextBoxTitle, TextBoxSubTitle, CellDisclosure } from "@salutejs/plasma-ui"
import { ReactElement } from "react"

type ApplicationCardProps = {
    number: string,
    status: string,
    product: string,
    date: string
}

function ApplicationCard (props: ApplicationCardProps) {
    return (
        <>
            <Card style={{ width: '100%', marginLeft: '0.75rem', marginTop: "1rem"}}>
                <CardContent compact>
                    <Cell
                        content={<TextBoxBigTitle>Заявка №{props.number}</TextBoxBigTitle>  as (ReactElement & string)}
                        contentRight={<span style={{ marginTop: 5 }}>{props.status}</span>}
                    />
                    <CellListItem
                        contentLeft={
                            <CellIcon>
                                <IconInfo />
                            </CellIcon>
                        }
                        content={
                            <TextBox>
                                <TextBoxTitle>{props.product}</TextBoxTitle>
                                <TextBoxSubTitle>Заявлен {props.date}</TextBoxSubTitle>
                            </TextBox>  as (ReactElement & string)
                        }
                        contentRight={<CellDisclosure />}
                    />
                </CardContent>
            </Card>
        </>
    )
}

export default ApplicationCard