class SmallGameField(N: Int = 3) {
    private var gameField: Array<Array<String>> = Array(N) { Array(N) { "[ ]" } }
    private var winCounter:Int = 1
    private val range:Int = N
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
    fun checkWinInField(): Boolean {
        var first=""
        fun checkRows(): Int {
            for(i in gameField.indices){
                for(j in 0 until gameField[i].size){
                    if((gameField[i][j]==first) and (gameField[i][j]!="[ ]")){

                        winCounter+=1
                    }
                    else{
                        first=gameField[i][j]
                    }
                    if(winCounter==range){
                        //println("win row $i")
                        first=""
                        return i
                    }
                }
                //println("row ${i+1} = $winCounter, $range")
                winCounter=1
            }
            first=""
            return -1
        }
        fun checkCols(): Int {
            for(j in gameField.indices){
                for(i in 0 until gameField[j].size){
                    if((gameField[i][j]==first) and (gameField[i][j]!="[ ]")){

                        winCounter+=1
                    }
                    else{
                        first=gameField[i][j]
                    }
                    if(winCounter==range){
                        //println("win col $j")
                        first=""
                        return j
                    }
                }
                //println("col ${j+1} = $winCounter, $range")
                winCounter=1
            }
            first=""
            return -1
        }
        fun checkDiagonals():Int{
            val maxIdx:Int = gameField.size - 1
            for (i in maxIdx downTo 0) {
                if((gameField[i][i]==first) and (gameField[i][i]!="[ ]")){
                    winCounter+=1
                }
                else{
                    first=gameField[i][i]
                }
                if(winCounter==range){
                    //println("win col $j")
                    first=""
                    return i
                }
            }
            winCounter=1
            first=""

            for (i in maxIdx downTo 0) {
                if((gameField[i][maxIdx - i]==first)and(gameField[i][maxIdx - i]!="[ ]")){
                    winCounter+=1
                }
                else{
                    first=gameField[i][maxIdx - i]
                }
                if(winCounter==range){
                    //println("win col $j")
                    first=""
                    return i
                }
            }
            winCounter=1
            first=""
            return -1

        }
        return !((checkRows() ==-1) and (checkCols()==-1) and (checkDiagonals()==-1))


    }

}
