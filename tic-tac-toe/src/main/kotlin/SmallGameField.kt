class SmallGameField(N: Int = 3) {
    private var gameField: Array<Array<String>> = Array(N) { Array(N) { "[ ]" } }
    fun printField() {
        for (i in gameField) {
            for (j in i) {
                print("$j ")
            }
            println()
        }
    }
    fun getArray(): Array<Array<String>> {
        return gameField
    }
    fun checkWin(){

    }

}