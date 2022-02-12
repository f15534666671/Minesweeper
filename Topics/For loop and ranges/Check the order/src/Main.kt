fun main() {
    // write your code here
    val num = readLine()!!.toInt()
    val seq : MutableList<Int> = mutableListOf()
    repeat(num) {
        seq.add(readLine()!!.toInt())
    }
    val sortedSeq = seq.toMutableList()
    sortedSeq.sort()
    println(if (seq == sortedSeq) "YES" else "NO" )
}
