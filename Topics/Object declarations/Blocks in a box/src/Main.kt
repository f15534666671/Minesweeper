class Block(val color: String) {

    object BlockProperties {
        var width = 4
        var length = 6

        fun blocksInBox(_length: Int, _width: Int):Int {
            return (_length / length) * (_width / width)
        }
    }

    var width = BlockProperties.width
    var length = BlockProperties.length
}