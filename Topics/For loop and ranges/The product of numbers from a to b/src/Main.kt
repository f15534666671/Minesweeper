fun main() {
    // put your code here
    val range = readLine()!!.toInt() until readLine()!!.toInt()
    var sum : Long = 1
    for (i in range) {
        sum *= i
    }
    println(sum)
    
}
