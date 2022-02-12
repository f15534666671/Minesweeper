fun main() {
    // write your code here
    val str1 = readLine()!!.toString()
    val op = readLine()!!.toString()
    val str2 = readLine()!!.toString()
    println(when(op) {
        "equals" -> str1 == str2
        "plus" -> str1 + str2
        "endsWith" -> str1.endsWith(str2)
        else -> "Unknown operation"
    })
}