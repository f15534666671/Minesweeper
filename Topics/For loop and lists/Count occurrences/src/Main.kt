fun main() {
    // write your code here
    val size = readLine()!!.toInt()
    val mutList: MutableList<Int> = mutableListOf()
    for (i in 0 until size) {
        mutList.add(readLine()!!.toInt())
    }
    val value = readLine()!!.toInt()
    var sum = 0
    for (element in mutList) {
        if (element == value) sum++
    }
    println(sum)


}