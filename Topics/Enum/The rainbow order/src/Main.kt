fun main() {
    val color = readLine()!!
    // put your code here
    for (enum in Rainbow.values()) {
        if (color.toUpperCase() == enum.name) println(enum.ordinal + 1)
    }
}

enum class Rainbow(val color: String) {
    RED("Red"),
    ORANGE("Orange"),
    YELLOW("Yellow"),
    GREEN("Green"),
    BLUE("Blue"),
    INDIGO("Indigo"),
    VIOLET("Violet")
}