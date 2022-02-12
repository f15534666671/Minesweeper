fun main() {
    // write your code here
    val companyNums = readLine()!!.toInt()
    val annualIncome = MutableList(companyNums) { readLine()!!.toInt() }
    val taxPercentages = MutableList(companyNums) { readLine()!!.toInt() }

    val taxes = mutableListOf<Int>()
    for (i in 0 until companyNums) {
        taxes.add(annualIncome[i] * taxPercentages[i])
    }
    println(taxes.indexOf(taxes.maxOrNull()) + 1)
}
