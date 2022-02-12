fun main() {
    //Do not touch code below
    var inputList: MutableList<MutableList<String>> = mutableListOf()
    val n = readLine()!!.toInt()
    for (i in 0 until n) {
        val strings = readLine()!!.split(' ').toMutableList()
        inputList.add(strings)
    }
    //write your code here
    val bottomIndex = inputList.lastIndex
    val lt = inputList[0][0]
    val rt = inputList[0][inputList[0].lastIndex]
    val lb = inputList[bottomIndex][0]
    val rb = inputList[bottomIndex][inputList[bottomIndex].lastIndex]
    println("$lt $rt")
    println("$lb $rb")

}