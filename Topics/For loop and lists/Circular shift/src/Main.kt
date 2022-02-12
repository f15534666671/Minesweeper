fun main() {
    // write your code here
    val size = readLine()!!.toInt()
    val A = MutableList(size) { readLine()!!.toInt() }
    A.add(0, A.removeLast())
    println(A.joinToString(" "))
}