fun main() {
    // write your code here
    val house = readLine()!!.toString()
    println(
        when (house) {
            "gryffindor" -> "bravery"
            "hufflepuff" -> "loyalty"
            "slytherin" -> "cunning"
            "ravenclaw" -> "intellect"
            else -> "not a valid house"
        }
    )
}
