fun main() {
    val year = readLine()!!.toInt()
    val result = if ( year % 4 == 0 && year % 100 != 0 ) "Leap" else if ( year % 400 == 0) "Leap" else "Regular"
    println(result)
}
