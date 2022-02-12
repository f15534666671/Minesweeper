class City(val name: String) {
    var degrees: Int = 0
        set(value) {
            field = when {
                value < -92 || value > 57 -> defaultDegrees
                else -> value
            }
        }
    val defaultDegrees = when (name) {
        "Moscow" -> 5
        "Hanoi" -> 20
        else -> 30
    }
}        

fun main() {
    val first = readLine()!!.toInt()
    val second = readLine()!!.toInt()
    val third = readLine()!!.toInt()
    val firstCity = City("Dubai")
    firstCity.degrees = first
    val secondCity = City("Moscow")
    secondCity.degrees = second
    val thirdCity = City("Hanoi")
    thirdCity.degrees = third

    //implement comparing here
    var coldestCity = when {
        firstCity.degrees <= secondCity.degrees && firstCity.degrees <= thirdCity.degrees -> firstCity
        secondCity.degrees <= firstCity.degrees && secondCity.degrees <= thirdCity.degrees -> secondCity
        else -> thirdCity
    }
    var occurNums = 0
    if (coldestCity.degrees == firstCity.degrees)  occurNums += 1
    if (coldestCity.degrees == secondCity.degrees) occurNums += 1
    if (coldestCity.degrees == thirdCity.degrees) occurNums += 1
    print(if (occurNums > 1) "neither" else coldestCity.name)
}