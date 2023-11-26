import { RouterProvider, createBrowserRouter } from "react-router-dom";
import ApplicationList, { ApplicationsLoader } from "./page/ApplicationList";
import { Container, Headline1, TextL } from "@salutejs/plasma-ui";
import { voicePhraseGradient } from "@salutejs/plasma-tokens";
import ApplicationDetails, { ApplicationLoader } from "./page/ApplicationDetails";
import { AssistantAppState, AssistantClient, AssistantClientCustomizedCommand, AssistantSmartAppData, createAssistant, createSmartappDebugger } from '@salutejs/client';
import { Dispatch } from "react";
import React from "react";


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



const initialize = (getState : any, getRecoveryState : any) : any => {
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





class App extends React.Component<{}, {assistant: any}> {
  public constructor(props : any){
    super(props);
  let asst = initialize(() => {return {tag: "123"}}, () => {return {tag: "123"}});
  this.state = { 
    assistant: asst,
  }
  this.state.assistant.on('data', (command : any) => {
  console.log(command);
  // Подписка на команды ассистента, в т.ч. команда инициализации смартапа.
  // Ниже представлен пример обработки голосовых команд "ниже"/"выше"
  if (command.navigation) {
      switch(command.navigation.command) {
          case 'UP':
              window.scrollTo(0, 0);
              break;
          case 'DOWN':
              window.scrollTo(0, 1000);
              break;
      }
  }
});


  }
  public render(){
  return <>
    <Headline1 style={{
      paddingLeft: 40,
      paddingTop: 20,
      paddingBottom: 20,
      borderRadius: 20, 
      fontSize: "2rem",
      color: "white",
      opacity: 0.7,
      backgroundImage: voicePhraseGradient
    }} onClick={() => {
      alert("123")
      this.state.assistant.sendData({ action: { action_id: 'some_action_name', parameters: { param: 'some' } } });}}>
      <TextL>СБЕР помощник</TextL>
    </Headline1>
    <Container>
      <RouterProvider router={router} />
    </Container>
  </>
  }
}

export default App;