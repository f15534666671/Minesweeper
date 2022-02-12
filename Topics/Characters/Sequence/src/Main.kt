fun main() {
    // put your code here
    val chars = MutableList(3) { readLine()!!.get(0) }
    println(chars[0] + 1 == chars[1] && chars[1] + 1 == chars[2])
}