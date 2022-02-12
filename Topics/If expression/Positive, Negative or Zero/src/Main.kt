fun main() {
    // write your code here
    val num = readLine()!!.toInt()
    println(if (num > 0) "positive" else if (num < 0) "negative" else "zero")
}
