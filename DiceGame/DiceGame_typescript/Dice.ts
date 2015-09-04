module DiceGame_TS {
    export class Dice {
        private m_value: number;

        constructor() {
            this.m_value = 0;
        }

        public Roll(): void {
            this.m_value = Math.floor(Math.random() * (7 - 1)) + 1;
        }

        public GetValue(): number {
            return this.m_value;
        }
    }
}