enum class DangerLevel(val _level: Int) {
    HIGH(3),
    MEDIUM(2),
    LOW(1);

    fun getLevel() = _level
}