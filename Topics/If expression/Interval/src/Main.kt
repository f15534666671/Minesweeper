fun main() {
    val num = readLine()!!.toInt()
    val result = if (num > -15 && num <= 12) "True" 
                 else if (num > 14 && num < 17) "True"
                 else if (num >= 19) "True"
                 else "False"
    println(result)
}
