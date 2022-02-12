import kotlin.random.Random

fun generateTemperature(seed: Int): String{
    // write your code here
    val randomGenerator = Random(seed)
    val temperatureInAWeek = MutableList(7) { randomGenerator.nextInt(20, 31) }
    return temperatureInAWeek.joinToString(" ")
}
