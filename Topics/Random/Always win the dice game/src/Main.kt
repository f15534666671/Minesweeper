import kotlin.random.Random

fun createDiceGameRandomizer(n: Int): Int {
    // write your code here
    var seed = 0
    var firstSum = 0
    var secondSum = 0
    while (firstSum <= secondSum) {
        seed += 1
        val randomGenerator = Random(seed)
        val firstList = MutableList(n) { randomGenerator.nextInt() }
        val secondList = MutableList(n) { randomGenerator.nextInt() }
        firstSum = firstList.sum()
        secondSum = secondList.sum()
    }
    return seed
}
