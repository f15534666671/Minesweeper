fun main() {
    // put your code here
    val num = readLine()!!.toInt()
    val components = MutableList(num) { readLine()!!.toInt() }
    var larger = 0
    var smaller = 0
    for (i in components) {
        if (i == 1) larger += 1 else if (i == -1) smaller += 1
    }
    println("${components.size - larger - smaller} $larger $smaller")
}