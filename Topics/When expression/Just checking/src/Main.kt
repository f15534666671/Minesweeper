fun main() {
    // write your code here
    val language = readLine()!!.toInt()
    println(
        when (language) {
            1, 3, 4 -> "No!"
            2 -> "Yes!"
            else -> "Unknown number"
        }
    )
}