"use strict";
// type Box = {
//     contents?: any[]
// }
var _a, _b, _c, _d;
let box = {
    contents: [],
    contentLength: () => box.contents.length /*Com '!' você força a rodar o código*/
};
// box.contents?.push(12);
(_a = box.contents) === null || _a === void 0 ? void 0 : _a.push("sla");
let box2 = {
    contents: [],
    contentLength: () => { var _a, _b; return (_b = (_a = box.contents) === null || _a === void 0 ? void 0 : _a.length) !== null && _b !== void 0 ? _b : 0; }
};
(_b = box2.contents) === null || _b === void 0 ? void 0 : _b.push(12);
// box2.contents?.push("sla");
let box3 = {
    contents: [],
    contentLength: () => { var _a, _b; return (_b = (_a = box.contents) === null || _a === void 0 ? void 0 : _a.length) !== null && _b !== void 0 ? _b : 0; }
};
(_c = box3.contents) === null || _c === void 0 ? void 0 : _c.push(12);
(_d = box3.contents) === null || _d === void 0 ? void 0 : _d.push("sla");
function tes(arg) {
    return arg;
}
let n = tes(123);
function tes2(arg) {
    return arg;
}
// let n2: string = tes2(123);
let n3 = tes2("123");
