import { createGlobalStyle } from 'styled-components';
import { darkSber } from '@salutejs/plasma-tokens/themes'; // Или один из списка: darkEva, darkJoy, lightEva, lightJoy, lightSber
import {
    text, // Цвет текста
    background, // Цвет подложки
    gradient,
    gradientDevice, // Градиент
} from '@salutejs/plasma-tokens';
import { skeletonGradient } from '@salutejs/plasma-tokens/colors/values';

const DocumentStyle = createGlobalStyle`
    html:root {
        min-height: 100vh;
        color: ${text};
        background-color: ${background};
        background-image: ${gradient};
    }
`;
const ThemeStyle = createGlobalStyle(darkSber);
export const GlobalStyle = () => (
    <>
        <DocumentStyle />
        <ThemeStyle />
    </>
);