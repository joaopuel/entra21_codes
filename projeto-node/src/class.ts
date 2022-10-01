interface Pingable{
    ping(): void;
}

class Point implements Pingable{
    private _x: number = 0; /*Apenas pode ser acesado pela classe em que está descrito*/ /*Underline antes da variável é convenção para atributo privado*/
    protected y: number = 0; /*Pode ser acesado pela classe em que está descrito e suas derivadas*/
    readonly name: string = "This point"; /*Atributo apenas pode ser alterado pelo construtor*/

    constructor(otherName?: string){
        if(otherName !== undefined){
            this.name = otherName;
        }
    }

    static jump(){
        console.log("jump"); /*Método estático pode ser acessado sem instanciar a classe*/
    }

    ping(): void {
        console.log("ping"); /*A classe deve implementar o método descrito na interface que está implementando*/
    }

    // printPoint = () : string => {
    //     return `X: ${this.x}, Y: ${this.y}`
    // }

    printPoint = () : string => `X: ${this.x}, Y: ${this.y}`

    get x(): number {
        return this._x;
    }
    
    set x(val: number) {
        this._x = val;
    }
}

class DPoint extends Point {
    z: number = 0;

    // printPoint = () : string => {
    //     return super.printPoint() + `, Z: ${this.z}`
    // }

    printPoint = () : string => {
        return `X: ${this.x}, Y: ${this.y}, Z: ${this.z}`
    }
}

type TPoint = {
    x: number,
    y: number
}

let p = new DPoint("That point");

console.log(p.printPoint());

Point.jump(); /*Acessando o método jump sem instanciar a classe*/


class CBox<T> {
    _contents: T[] = [];

    addItem = (item:T) => this._contents.push(item);

    removeItem = () => this._contents.pop();

    get contents() {
        return this._contents;
    }

    set contents(val: T[]) {
        this._contents = val;
    }
}