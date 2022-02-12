fun main() {
    // write your code here
    val num = readLine()!!.toInt()
    val left = readLine()!!.toInt()
    val right = readLine()!!.toInt()
    println(num in left..right)
}