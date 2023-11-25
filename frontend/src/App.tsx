import { RouterProvider, createBrowserRouter } from "react-router-dom";
import ApplicationList from "./page/ApplicationList";
import { Container, Headline1, TextL } from "@salutejs/plasma-ui";
import { voicePhraseGradient } from "@salutejs/plasma-tokens";
import ApplicationDetails from "./page/ApplicationDetails";


const router = createBrowserRouter([
  {
    path: "/",
    element: <ApplicationList />,
  },
  {
    path: "/application/:applicationId",
    element: <ApplicationDetails />
  }
]);


function App() {
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
    }}>
      <TextL>СБЕР помощник</TextL>
    </Headline1>
    <Container>
      <RouterProvider router={router} />
    </Container>
  </>
}

export default App;