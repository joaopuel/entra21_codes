"use strict";
class Point {
    constructor(otherName) {
        this.x = 0;
        this.y = 0;
        this.name = "This point"; /*Atributo apenas pode ser alterado pelo construtor*/
        this.printPoint = () => {
            return `X: ${this.x}, Y: ${this.y}`;
        };
        if (otherName !== undefined) {
            this.name = otherName;
        }
    }
}
class DPoint extends Point {
    constructor() {
        super(...arguments);
        this.z = 0;
        this.printPoint = () => {
            return `, Z: ${this.z}`;
        };
    }
}
let p = new DPoint("That point");
console.log(p.printPoint());
