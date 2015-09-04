module DiceGame_TS {
    export class DiceGame {
        private m_d1: Dice;
        private m_d2: Dice;

        constructor() {
            this.m_d1 = new Dice();
            this.m_d2 = new Dice();
        }

        public Play(): boolean {
            this.m_d1.Roll();
            this.m_d2.Roll();
            return this.m_d1.GetValue() + this.m_d2.GetValue() === 7;
        }
    }
}