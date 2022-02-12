// complete this function, add default values
fun carPrice(old: Int = 5, kilometers: Int = 100000, maximumSpeed: Int = 120, automatic: Boolean =false) {
    val oldPrice = 20000 - old * 2000 + (maximumSpeed - 120) * 100 - (kilometers / 10000) * 200
    println( if (automatic) oldPrice + 1500 else oldPrice )
}