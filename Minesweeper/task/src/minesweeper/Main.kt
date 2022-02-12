package minesweeper

import kotlin.math.min
import kotlin.random.Random
/**
class MineField(private var size: Int = 9, var mines: Int){
    private val line = MutableList(size) { SAFE_CELL}
    private val field = MutableList(size) { line.toMutableList() }
    var fieldReplaceMineWithMark = MutableList(size) { line.toMutableList() }
    var playerProgress = MutableList(size) { line.toMutableList() }

    init {
        generateMine()
        generateFieldWithClue()
        initPlayerProgressAndField()
    }

    fun showPlayerProgress() {
        /**
         * 输出当前用户进度
         */
        println(" │123456789│")
        println("—│—————————│")
        for (i in playerProgress.indices) {
            println("${i + 1}│" + playerProgress[i].joinToString("") + "│")
            // print("${i + 1}│" + playerProgress[i].joinToString("") + "│")
            // print("${i + 1}│" + fieldReplaceMineWithMark[i].joinToString("") + "│")
            // println("${i + 1}│" + field[i].joinToString("") + "│")
        }
        println("—│—————————│")
    }

    fun updatePlayerProgress(row: Int, col: Int): Boolean {
        /**
         * 根据输入更新当前用户进度
         */
        return when(playerProgress[row][col]) {
            MARK -> { playerProgress[row][col] = SAFE_CELL; true
            }
            SAFE_CELL -> { playerProgress[row][col] = MARK; true
            }
            else -> false
        }
    }

    private fun initPlayerProgressAndField() {
        /**
         * 生成初始游戏进度playerProgress与检查游戏进度的对比对象fieldReplaceMineWithMark
         */

        for (i in 0 until size) {
            playerProgress[i] = field[i].toMutableList()
            fieldReplaceMineWithMark[i] = field[i].toMutableList()
            for (j in 0 until size){
                if (field[i][j] == MINE) {
                    playerProgress[i][j] = SAFE_CELL
                    fieldReplaceMineWithMark[i][j] = MARK
                }

            }
        }
    }

    private fun generateMine() {
        // 生成雷的随机位置
        val randomMines = mutableListOf<Int>()
        val defaultGenerator = Random.Default
        repeat(mines) {
            var nextPosition = defaultGenerator.nextInt(size * size)
            while ( nextPosition in randomMines) {
                nextPosition = defaultGenerator.nextInt(size * size)
            }
            randomMines.add(nextPosition)
        }
        // 布雷
        for (element in randomMines) {
            val rowIndice = element / size
            val colIndice = element % size
            field[rowIndice][colIndice] = MINE
        }
    }

    private fun generateFieldWithClue() {
        /**
         * 生成雷区图，包含提示线索，这是最终field属性拥有的值
         */
        fun calculateMineNums(rowIndice: Int, colIndice: Int): Int {
            /**
             * 计算当前位置周围的雷数，若是雷则不计算直接返回0
             */
            var nums = 0
            if (field[rowIndice][colIndice] != MINE) {
                if (rowIndice - 1 >= 0) {
                    if (colIndice - 1 >= 0 && field[rowIndice - 1][colIndice - 1] == MINE) nums += 1
                    if (field[rowIndice - 1][colIndice] == MINE) nums += 1
                    if (colIndice + 1 < size && field[rowIndice - 1][colIndice + 1] == MINE) nums += 1
                }
                if (colIndice - 1 >= 0 && field[rowIndice][colIndice - 1] == MINE) nums += 1
                if (colIndice + 1 < size && field[rowIndice][colIndice + 1] == MINE) nums += 1
                if (rowIndice + 1 < size) {
                    if (colIndice - 1 >= 0 && field[rowIndice + 1][colIndice - 1] == MINE) nums += 1
                    if (field[rowIndice + 1][colIndice] == MINE) nums += 1
                    if (colIndice + 1 < size && field[rowIndice + 1][colIndice + 1] == MINE) nums += 1
                }
            }

            return nums
        }

        for (pos in 0 until size * size) {
            val rowIndice = pos / size
            val colIndice = pos % size
            val mineNums = calculateMineNums(rowIndice, colIndice)
            if (mineNums != 0) field[rowIndice][colIndice] = mineNums.toString()
        }
    }

    companion object {
        const val MINE = "X"
        const val SAFE_CELL = "."
        const val MARK = "*"
    }
}

fun main() {

    print("How many mines do you want on the field? > ")
    val numOfMines = readLine()!!.toInt()
    val mineField = MineField(mines = numOfMines)
    mineField.showPlayerProgress()
    while (mineField.playerProgress != mineField.fieldReplaceMineWithMark) {
        print("Set/delete mines marks (x and y coordinates): > ")
        val playerMarkPos = readLine()!!.split(" ").map { it.toInt() }.toMutableList()
        if (mineField.updatePlayerProgress(playerMarkPos[1] - 1, playerMarkPos[0] - 1)) mineField.showPlayerProgress() else println("There is a number here!")
    }
    println("Congratulations! You found all the mines!")
}
*/

class Minesweeper(val mineNums: Int,
                  val size: Int = 9, ) {

    val minesPos = mutableListOf<Int>()
    val minefield = MutableList(size) { MutableList(size) { UNEXPLORED_CELL } }

    init {
        showMinefield()
        var input = mutableListOf<String>()
//        do {
//            print("Set/unset mines marks or claim a cell as free: > ")
//            input = readLine()!!.split(" ").toMutableList()
//        }while (!(input.size == 3 && input[2] == "free"))
        print("Set/unset mines marks or claim a cell as free: > ")
        input = readLine()!!.split(" ").toMutableList()
        generateMines(input[0].toInt() - 1, input[1].toInt() - 1)
        updatePlayerProgress(input[0].toInt() - 1, input[1].toInt() - 1, input[2])
    }

    private fun neighborOfPoint(pointPos: Int): MutableList<Int> {
        val row = pointPos / size
        val col = pointPos % size
        val neighborOfPoint = mutableListOf<Int>()
        if (row - 1 >= 0) {
            if (col - 1 >= 0) neighborOfPoint.add((row - 1) * size + col - 1)
            neighborOfPoint.add((row - 1) * size + col)
            if (col + 1 < size) neighborOfPoint.add((row - 1) * size + col + 1)
        }
        if (col - 1 >= 0) neighborOfPoint.add(row * size + col - 1)
        if (col + 1 < size) neighborOfPoint.add(row * size + col + 1)
        if (row + 1 < size) {
            if (col - 1 >= 0) neighborOfPoint.add((row + 1) * size + col - 1)
            neighborOfPoint.add((row + 1) * size + col)
            if (col + 1 < size) neighborOfPoint.add((row + 1) * size + col + 1)
        }
        return neighborOfPoint
    }

    private fun generateMines(col: Int, row: Int) {
        // 生成雷的随机位置
        val neighborOfInitPos = neighborOfPoint(row * size + col)
        neighborOfInitPos.add(row * size + col)
        val defaultGenerator = Random.Default
        repeat(mineNums) {
            var nextPosition = defaultGenerator.nextInt(size * size)
            while ( nextPosition in minesPos || nextPosition in neighborOfInitPos) {
                nextPosition = defaultGenerator.nextInt(size * size)
            }
            minesPos.add(nextPosition)
        }
//        // 布雷
//        for (element in randomMines) {
//            val rowIndice = element / size
//            val colIndice = element % size
//            minefield[rowIndice][colIndice] = MINE
//        }
    }

    private fun updateFreePoint(col: Int, row: Int): MutableList<Int> {
        // if (minefield[row][col] == UNEXPLORED_CELL) minefield[row][col] = FREE_CELL
        val neighborOfPoint = neighborOfPoint(row * size + col)
        var neighborMines = 0
        for (point in neighborOfPoint) {
            if (point in minesPos) neighborMines += 1
        }
        val nextPoints = mutableListOf<Int>()
        if (neighborMines == 0) {
            if (minefield[row][col] !in NUM) minefield[row][col] = FREE_CELL
            for (point in neighborOfPoint) {
                if (minefield[point / size][point % size] !in NUM){
                    val itsNeighbor = neighborOfPoint(point)
                    var minesNumInItsNeighbor = 0
                    for (point in itsNeighbor) {
                        if (point in minesPos) minesNumInItsNeighbor += 1
                    }
                    if (minesNumInItsNeighbor != 0) {
                        minefield[point / size][point % size] = minesNumInItsNeighbor.toString()
                    } else {
                        nextPoints.add(point)
                    }

                }
            }
        } else {
            minefield[row][col] = neighborMines.toString()
        }
        return nextPoints
    }

    fun updatePlayerProgress(col: Int, row: Int, mode: String): Boolean {
        if (mode == MINE_MODE) {
            when (minefield[row][col]) {
                UNEXPLORED_CELL -> minefield[row][col] = UNEXPLORED_MARKED_CELL
                UNEXPLORED_MARKED_CELL -> minefield[row][col] = UNEXPLORED_CELL
            }
            return true
        } else {
            val pos = row * size + col
            return if (pos in minesPos) {
                for (pos in minesPos) {
                    minefield[pos / size][pos % size] = MINE
                }
                false
            } else {
                var nextPoints = mutableListOf<Int>(pos)
                var index = 0
                do {
                    val point = nextPoints[index]
                    val freeNeighborOfPoint = updateFreePoint(point % size, point / size)
                    for (elem in freeNeighborOfPoint) {
                        if ( elem !in nextPoints) nextPoints.add(elem)
                    }
                    index++
                    // println(nextPoints)
                }while(index <= nextPoints.lastIndex)
                true
            }
        }
    }

    fun showMinefield() {
        println()
        println(" │123456789│")
        println("—│—————————│")
        for (i in minefield.indices) {
            println("${i + 1}│" + minefield[i].joinToString("") + "│")
        }
        println("—│—————————│")
    }

    fun checkMines(): Boolean {
        for (i in 0 until size * size) {
            if (minefield[i / size][i % size] == "*" && i !in minesPos) return false
            if (minefield[i / size][i % size] != "*" && i in minesPos) return false
        }
        return true
    }

    fun checkSafeCells(): Boolean {
        for (i in 0 until size * size) {
            if (i in minesPos) {
                continue
            } else {
                if (minefield[i /size][i % size] == UNEXPLORED_CELL) return false
            }
        }
        return true
    }


    companion object {
        const val UNEXPLORED_CELL = "."
        const val FREE_CELL = "/"
        const val MINE = "X"
        const val UNEXPLORED_MARKED_CELL = "*"
        val NUM = mutableListOf<String>("1", "2", "3", "4", "5", "6", "7", "8", "9")

        const val MINE_MODE = "mine"
        const val FREE_MODE = "free"
    }
}

fun main() {
    print("How many mines do you want on the field? > ")
    val mineNums = readLine()!!.toInt()
    val minesweeper = Minesweeper(mineNums)
    do {
        minesweeper.showMinefield()
        var input = mutableListOf<String>()
        do {
            print("Set/unset mines marks or claim a cell as free: > ")
            input = readLine()!!.split(" ").toMutableList()
        } while (!(input.size == 3 && input[2] in mutableListOf("free", "mine")))
    }while (minesweeper.updatePlayerProgress(input[0].toInt() - 1, input[1].toInt() - 1, input[2])
        && !minesweeper.checkMines() && !minesweeper.checkSafeCells())

    minesweeper.showMinefield()
    if (minesweeper.checkMines() || minesweeper.checkSafeCells()) {
        println("Congratulations! You found all the mines!")
    } else {
        println("You stepped on a mine and failed!")
    }

}