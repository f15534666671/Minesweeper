fun main() {
    // write your code here
    val size = readLine()!!.toInt()
    var mutList: MutableList<Int> = mutableListOf()
    repeat(size) {
        mutList.add(readLine()!!.toInt())
    }
    val rotaPos = mutList.lastIndex - readLine()!!.toInt() % size + 1
    val list = mutList.subList(rotaPos, mutList.lastIndex + 1) + mutList.subList(0, rotaPos)
    println(list.joinToString(" "))
}
