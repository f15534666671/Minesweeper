fun main() {
    // write your code here
    val num = readLine()!!.toInt()
    val seq = MutableList(num) { readLine()!!.toInt() }
    val value = readLine()!!.toInt()
    var result = "NO"
    for (elem in seq) {
        if (elem == value) {
            result = "YES"
            break
        }
    }
    println(result)

}