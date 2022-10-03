class BigGameField(N: Int = 3) {
    private val listOfCharX: Array<String> = arrayOf("х", "Х", "x", "X")
    private val listOfChar0: Array<String> = arrayOf("0", "o", "O", "о", "О")
    private var moves = emptyArray<List<String>>()
    private val range: Int = N
    private var bigGameField = Array(N) { Array(N) { SmallGameField(N) } }
    private var player1chose: String = ""
    private var player2chose: String = ""

    fun printAllField() {
        for (w in 0 until range) {
            for (x in 0 until range) {
                for (y in 0 until range) {
                    for (z in 0 until range) {
                        print(bigGameField[w][y].getArray()[x][z])
                        if (z != range - 1) {
                            print(" ")
                        }
                    }
                    if (y != range - 1) print(" * ")
                }
                println()
            }
            println()

        }
    }

    fun printIndexField(x: Int, y: Int) {
        bigGameField[x][y].printField()
    }

    fun choseF() {
        var ch: String
        do {
            println("chose symbol for player1 (X/0)")
            ch = readLine().toString()
        } while (!move(moveChar = ch))

        player1chose = ch
        player2chose = if (player1chose in listOfChar0) {
            "X"
        } else {
            "0"
        }

    }

    fun currentPlayerChose(): String {
        return if (moves.size % 2 == 0) {
            player1chose
        } else {
            player2chose
        }
    }

    fun player(): Int {
        if (moves.size % 2 == 0) {
            return 1
        }
        return 2
    }

    fun checkWinInGame(): Boolean {
        for (i in bigGameField.indices) {
            for (j in 0 until bigGameField[i].size) {
                if (bigGameField[i][j].checkWinInField()) {
                    return true
                }
            }
        }
        return false

    }

    fun move(x: Int = range / 2, y: Int = range / 2, moveChar: String): Boolean {
        fun isMoveCorrect(): Boolean {

            return (x+1 <= range) and (y+1 <= range) and (x+1>0) and(y+1>0)
        }

        fun isSymbolCorrect(moveChar: String): Boolean {
            if ((moveChar in listOfCharX) or (moveChar in listOfChar0)) {
                return true
            }
            return false

        }

        fun isFirstMove(): Boolean {
            if (moves.isEmpty()) {
                return true
            }
            return false
        }

        fun isCellFree(x1: Int, y1: Int, x2: Int, y2: Int): Boolean {
            if (bigGameField[x1][y1].getArray()[x2][y2] == "[ ]") {
                return true
            }
            return false
        }

        fun makeMove(x: Int, y: Int, moveChar: String) {
            bigGameField[moves.last()[2].toInt()][moves.last()[1].toInt()].getArray()[y][x] = "[$moveChar]"
            println("player was moved [$moveChar] in (x = ${x + 1}, y = ${y + 1} cell) in (x = ${moves.last()[1].toInt() + 1}, y = ${moves.last()[2].toInt() + 1} field), next move must be in (x = ${x + 1}, y = ${y + 1} field)")
            moves += listOf(moveChar, x.toString(), y.toString())
            //if (checkWinInGame()) {
            //println("win")
            //}
        }

        fun makeFirstMove() {
            bigGameField[range / 2][range / 2].getArray()[range / 2][range / 2] = "[$moveChar]"
            moves += listOf(moveChar, x.toString(), y.toString())
        }

        //println("x = $x, y = $y, s = $moveChar")
        if (isSymbolCorrect(moveChar)) {
            if (isMoveCorrect()) {
                //println("symbol correct")
                return if (isFirstMove()) {
                    makeFirstMove()
                    true
                } else {
                    if (isCellFree(moves.last()[2].toInt(), moves.last()[1].toInt(), y, x)) {
                        makeMove(x, y, moveChar)
                        bigGameField[0][0].checkWinInField()
                        true
                    } else {
                        println("(cell ${x+1}, ${y+1}) is not free in (field ${moves.last()[2].toInt()+1}, ${moves.last()[1].toInt()+1})")
                        false
                    }

                }
            } else {

                println("move digit out of field")
                return false
            }

        }
        else {
            println("invalid symbol")
            return false
        }


    }
}