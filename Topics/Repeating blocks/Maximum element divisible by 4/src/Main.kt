fun main() {
    val num = readLine()!!.toInt()
    val seq = MutableList(num) { readLine()!!.toInt() }
    val result = mutableListOf<Int>()
    for (elem in seq) {
        if (elem % 4 == 0) result.add(elem)
    }
    println(result.maxOrNull())
}
