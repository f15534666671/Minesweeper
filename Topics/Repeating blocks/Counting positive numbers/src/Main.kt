fun main() {
    // put your code here
    val num = readLine()!!.toInt()
    val seq = MutableList(num) { readLine()!!.toInt() }
    var sum = 0
    for (elem in seq) {
        if (elem > 0) sum += 1
    }
    println(sum)
}