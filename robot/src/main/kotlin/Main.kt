enum class Direction {
    UP, LEFT, DOWN, RIGHT
}



fun main() {
    val r = Robot(1, 1, Direction.RIGHT)
    //println(r)
    moveRobot(3, 2,r)
    //println(r)

}