class DiceGame {
    val WIN_CONDITION: Int = 7
    var dice1: Dice = Dice()
    var dice2: Dice = Dice()

    fun play(): Boolean {
        dice1.roll()
        dice2.roll()

        return dice1.getValue() + dice2.getValue() == WIN_CONDITION
    }
}