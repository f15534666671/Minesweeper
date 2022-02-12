fun main() {
    // write your code here
    val mutList = MutableList(readLine()!!.toInt()) { readLine()!!.toInt() }
    val valueList = readLine()!!.split(" ").map { it.toInt() }
    println( if (valueList[0] in mutList && valueList[1] in mutList) "YES" else "NO")
}