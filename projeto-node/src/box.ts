
// type Box = {
//     contents?: any[]
// }

// let box : Box = {};

// box.contents?.push("conteúdo");

// let box : Box = {
//     contents: []
// };

// box.contents?.push("conteúdo");

type Box<Type = any> = {
    contents?: Type[],
    contentLength: () => number;
}

let box: Box<string> = {
    contents: [],
    contentLength: () => box.contents!.length /*Com '!' você força a rodar o código*/
};

// box.contents?.push(12);
box.contents?.push("sla");

let box2: Box<number> = {
    contents: [],
    contentLength: () => box.contents?.length ?? 0
};

box2.contents?.push(12);
// box2.contents?.push("sla");

let box3: Box = {
    contents: [],
    contentLength: () => box.contents?.length ?? 0
};

box3.contents?.push(12);
box3.contents?.push("sla");

function tes(arg: any): any {
    return arg;
}

let n: string = tes(123);

function tes2<T>(arg: T): T {
    return arg;
}

// let n2: string = tes2(123);
let n3: string = tes2("123");


