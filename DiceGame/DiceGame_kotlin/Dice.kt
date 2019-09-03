import kotlin.random.Random

class Dice {

    private var value: Int = 0

    fun roll() {
        value = Random.nextInt(1, 7)
        println(value)
    }

    fun getValue(): Int {
        return value
    }
}
