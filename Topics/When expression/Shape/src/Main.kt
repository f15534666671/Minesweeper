fun main(args: Array<String>) {
    // write your code here
    val num = readLine()!!.toInt()
    val str = "You have chosen a "
    println( when(num) {
        1 -> str + "square"
        2 -> str + "circle"
        3 -> str + "triangle"
        4 -> str + "rhombus"
        else -> "There is no such shape!"
    })
}