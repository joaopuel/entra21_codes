// console.log("teste")

// console.log(4 / []); /*Typescript mostra como erro essa expressão ao contrário de Javascript*/

// let rect = {
//     width: 20,
//     heigth: 30
// };

// console.log(rect.height); /*A palavra 'height' está escrita errada e apenas o Typescript aponta o erro*/

// let numeros: number | string | boolean; /*A variável numeros pode receber números, string ou booleano*/

// let numeros: (string|number)[]; /*A variável numeros é uma array que só pode receber números ou string*/

// let numeros: any[]; /*A variável é uma array que pode receber qualquer tipo de dado*/

// numeros = [1, "sla"];

// let numeros: string;
// let f = (x: number, y: number) : string => {
//     return "" + x + y;
// };
// numeros = f(2,6);
// console.log(numeros);

type Rect = {
    width?: number, /*Com '?' a propriedade não é obrigatória*/
    height?: number /*Com '?' a propriedade não é obrigatória*/
};

let rect: Rect = {
    width: 20,
    height: 30
};

let qua: Rect = {
    width: 30
};

type Triangle = {
    angle: number,
    type: "isoceles" | "scalene" | "obtuse"
};

let tri: Triangle = {
    angle: 45,
    type: "isoceles"
};

type Circle = {
    radius: number;
}

type GeometricFigure = Rect | Triangle | Circle;

let c: GeometricFigure = {
    radius: 5,
    width: 3,
    type: "scalene"
}