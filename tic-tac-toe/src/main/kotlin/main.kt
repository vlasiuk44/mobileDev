fun main() {
    val game = BigGameField(5) //n must be odd
    game.printIndexField(0,0)
    game.choseF()
    game.printAllField()


    while (!game.checkWinInGame()) {
        println("player ${game.player()} make move: ")
        val moveX= readLine()
        val moveY= readLine()
        game.move(moveX!!.toInt() - 1, moveY!!.toInt() - 1, game.currentPlayerChose())
        game.printAllField()

    }
    println("player ${game.player()} has lost")


}