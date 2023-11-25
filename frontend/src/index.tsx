import { DeviceThemeProvider, SSRProvider } from '@salutejs/plasma-ui';
import { GlobalStyle } from './GlobalStyle';
import App from './App'
import * as ReactDOM from 'react-dom';
import {
    createBrowserRouter,
    RouterProvider,
  } from "react-router-dom";



ReactDOM.render(
    <DeviceThemeProvider>
        <SSRProvider>
            <App/>
            <GlobalStyle />
        </SSRProvider>
    </DeviceThemeProvider>,
    document.getElementById('root'),
);