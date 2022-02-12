fun main() {
    // write your code here
    val N = readLine()!!.toInt()
    val list = MutableList(N) { readLine()!!.toInt() }
    val result = list.removeAt(list.indexOf(list.maxOrNull()))
    println(if (N == 1) result else result * list.removeAt(list.indexOf(list.maxOrNull())))
}