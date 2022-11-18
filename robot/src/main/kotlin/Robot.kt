class Robot(private var x: Int, private var y: Int, private var direction: Direction) {

    fun getDirection(): Direction {
        return direction
    }

    fun getX(): Int {
        return x
    }

    fun getY(): Int {
        return y
    }

    fun turnLeft() {
        direction = when(direction) {
            Direction.UP -> Direction.LEFT
            Direction.LEFT -> Direction.DOWN
            Direction.DOWN -> Direction.RIGHT
            Direction.RIGHT -> Direction.UP
        }
    }

    fun turnRight() {
        direction = when (direction) {
            Direction.UP -> Direction.RIGHT
            Direction.LEFT -> Direction.DOWN
            Direction.DOWN -> Direction.LEFT
            Direction.RIGHT -> Direction.UP
        }
    }

    fun stepForward() {
        when (direction) {
            Direction.UP -> y += 1
            Direction.DOWN -> y -= 1
            Direction.LEFT -> x -= 1
            Direction.RIGHT -> x += 1
        }
    }

    override fun toString(): String {
        return "x: $x, y: $y, dir: $direction"
    }
}

fun moveRobot(x1: Int, y1: Int, robot: Robot) {
    val x = robot.getX()
    val dx = x1 - x
    if (dx > 0) {
        while (robot.getDirection() != Direction.RIGHT) robot.turnRight()
        while (robot.getX() < x1) {
            robot.stepForward()
            println(robot.toString())
        }
    }
    else {
        while (robot.getDirection() != Direction.LEFT) robot.turnLeft()
        while (robot.getX() > x1) {
            robot.stepForward()
            println(robot.toString())
        }
    }
    val y = robot.getY()
    val dy = y1 - y
    if (dy > 0) {
        while (robot.getDirection() != Direction.UP) robot.turnRight()
        while (robot.getY() < y1) {
            robot.stepForward()
            println(robot.toString())
        }
    }
    else {
        while (robot.getDirection() != Direction.DOWN) robot.turnLeft()
        while (robot.getY() > y1){
            robot.stepForward()
            println(robot.toString())
        }
    }
    println(robot.toString())
}