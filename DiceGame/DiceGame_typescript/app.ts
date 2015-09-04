module DiceGame_TS {
    export class app {
        element: HTMLElement;
        span: HTMLElement;

        game: DiceGame = new DiceGame();

        constructor(element: HTMLElement) {
            this.element = element;
            this.span = document.createElement('span');
            this.element.appendChild(this.span);
        }

        start() {
            if (this.game.Play())
                this.span.innerHTML = "You are a winner";
            else
                this.span.innerHTML = "Sorry";
        }
    }
}

window.onload = () => {
    var element = document.getElementById('content');
    var game = new DiceGame_TS.app(element);
    game.start();
};