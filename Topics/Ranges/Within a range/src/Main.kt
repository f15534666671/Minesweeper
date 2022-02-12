fun main() {
    // write your code here
    val left1 = readLine()!!.toInt()
    val right1 = readLine()!!.toInt()
    val left2 = readLine()!!.toInt()
    val right2 = readLine()!!.toInt()
    val range1 = if (left1 < right1) left1..right1 else right1..left1
    val range2 = if (left2 < right2) left2..right2 else right2..left1
    val num = readLine()!!.toInt()
    println(num in range1 || num in range2)
}