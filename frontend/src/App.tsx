import { RouterProvider, createBrowserRouter } from "react-router-dom";
import ApplicationList, { ApplicationsLoader } from "./page/ApplicationList";
import { Container, Headline1, TextArea, TextL } from "@salutejs/plasma-ui";
import { voicePhraseGradient } from "@salutejs/plasma-tokens";
import ApplicationDetails, { ApplicationLoader } from "./page/ApplicationDetails";
import { AssistantAppState, AssistantClient, AssistantClientCustomizedCommand, AssistantSmartAppData, createAssistant, createSmartappDebugger } from '@salutejs/client';
import { Dispatch } from "react";
import React from "react";
import { BlockNoteView, useBlockNote } from "@blocknote/react";
import "@blocknote/core/style.css";
import { Accordion, AccordionDetails, AccordionSummary } from "@mui/material";
import { IconChevronDown } from "@salutejs/plasma-icons";
import Spreadsheet from "react-spreadsheet";


const router = createBrowserRouter([
  {
    path: "/",
    loader: ApplicationsLoader,
    element: <ApplicationList />,
  },
  {
    path: "/application/:applicationId",
    loader: ApplicationLoader,
    element: <ApplicationDetails />
  }
]);



const initialize = (getState: any, getRecoveryState: any): any => {
  if (true) {
    return createSmartappDebugger({
      // Токен из Кабинета разработчика
      token: 'eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJqdGkiOiJlYTkwOWJiZi00YmQ2LTRmMjgtODQ5OC00ZWRiNzMyOTFiYzgiLCJzdWIiOiJwZW9wbGUvMTEyNTA2MTY2MDc4MzI2MTg4MDczIiwiaXNzIjoiS0VZTUFTVEVSIiwiZXhwIjoxNzAxMDQ0MTY0LCJhdWQiOiJWUFMiLCJpYXQiOjE3MDA5NTc3NTQsInNpZCI6IjU4YWZkMGRlLTdjOWYtNDIyMC05NzQ0LWMxZWFkNGE4OWE3ZCJ9.H634hik8DTyKm6OA6O5cxhHuIFDnSwzM7rgGrkHnf6uDoDKWj8eHJvqFXe8KyXaOljpNOcCFVQNlnqRn9J6hz6ZpY2LnaHQOkMPr-_OBto5TiiqVQL5RgWR8OwEIbLPA_C73kFUf7kFzZZRUWv1eYf7q7Y8nIG7uySfJOkm1qVIpKPaLgNhK7Ka4FD5uIKNxOP9ZfSSksF00450AOkiWOo6gOhDJQGWZyBrJ2ENw-lMQk_JQ9ecW9LKGd4-scUK8f0XmnAXjvivUrsmuYhEf6nHZSYIPrWhQ_Zsu4EU4TXSWYunBn7sIrKwo0lo8-tktQ-bCq4qWfE0vWAJtgzCFBlfFmOKK0-6FmCLTliGIvsJM4Sd0qZybvKcsbYEBSBieJOnRmgDNTAVjbbUoFiAgTmVeRVLdXwuOWkhJcMXdDf0QXzW79wfQPGNWmyNQQVnlBa95vMwpPyyAFP331-d5zDQ0qc7gIlVZlbqv6ZBYzRXm4QnlV1N3W5NnJK9vmNMYP05Ol51illtPcOioXdWoPVVl9E6Ogb6LfTD0LkPJo5QQh5Y2HvW5cDJPRVbQHj9yBiLoLMpkEZuASXSQZiva42ftK36u-EaTUP75EMcf2poiaFjc5VxCS5d24ikwk-8W-h_ajCkXUzHKQgGA9aqkwdXHr09OzxtmVQJSKgZqoK0',
      // Пример фразы для запуска смартапа
      initPhrase: 'Запусти sber',
      // Текущее состояние смартапа
      getState,
      // Состояние смартапа, с которым он будет восстановлен при следующем запуске
      // Необязательные параметры панели, имитирующей панель на реальном устройстве
      nativePanel: {
        // Стартовый текст в поле ввода пользовательского запроса
        defaultText: '123',
        // Позволяет включить вид панели, максимально приближенный к панели на реальном устройстве
        screenshotMode: false,
        // Атрибут `tabindex` поля ввода пользовательского запроса
        tabIndex: -1,
      }
    });
  }

  // Только для среды production
  return createAssistant({ getState, getRecoveryState });
}



const assistant = initialize(() => { return { tag: "123" } }, () => { return { tag: "123" } });
assistant.on('data', (command: any) => {
  console.log(command);
  if (command.navigation) {
    switch (command.navigation.command) {
      case 'UP':
        window.scrollTo(0, 0);
        break;
      case 'DOWN':
        window.scrollTo(0, 1000);
        break;
    }
  }
});

function App(props: {}) {
  const editor = useBlockNote({
    onEditorContentChange: (editor: any) => {
      // Log the document to console on every update
      //console.log(editor.getJSON());
    },
  });

  return <>
    <Headline1 style={{
      paddingLeft: 40,
      paddingTop: 20,
      paddingBottom: 20,
      borderRadius: 20,
      fontSize: "2rem",
      color: "white",
      opacity: 1,
      backgroundImage: voicePhraseGradient
    }}>
      <TextL color="white">СБЕР помощник</TextL>
    </Headline1>
    <div style={{ position: "absolute", float: "left", width: "25%", marginTop: "1rem", minHeight: "10rem" }}>
      <Accordion>
        <AccordionSummary style={{ backgroundColor: "rgba(240, 240, 240, .5)", border: '1px solid rgba(0, 0, 0, .125)' }}>
          <div>Таблица</div>
          <IconChevronDown color="black" />
        </AccordionSummary>
        <AccordionDetails>
          <Spreadsheet data={Array.from(Array(5), () => new Array(3))} />
        </AccordionDetails>
      </Accordion>



      <div style={{ marginTop: 10 }}>
        <Accordion>
          <AccordionSummary style={{ backgroundColor: "rgba(240, 240, 240, .5)", border: '1px solid rgba(0, 0, 0, .125)' }}>
            <div style={{ display: "flex", justifyContent: "space-between", flexDirection: "row", alignItems: "center" }}>
              <div>Блокнот</div>
              <IconChevronDown color="black" />
            </div>

          </AccordionSummary>
          <AccordionDetails>
            <BlockNoteView editor={editor} />
          </AccordionDetails>
        </Accordion>
      </div>
    </div>

    <Container>
      <RouterProvider router={router} />
    </Container>
    <TextArea style={{ opacity: 0 }}></TextArea>
  </>
}
export default App;