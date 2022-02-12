import kotlin.random.Random

fun generatePredictablePassword(seed: Int): String {
    var randomPassword = ""
    // write your code here

    val randomGenerator = Random(seed)
    var password = MutableList(10) { randomGenerator.nextInt(33, 127).toChar() }
    randomPassword = password.joinToString("")
	return randomPassword
}