class Rect( var x: Int,  var y: Int,  var width: Int,  var height: Int) : Transforming, Movable, Figure(0) {
    lateinit var name: String
    override fun resize(sizeUp: Int) {
        width *= sizeUp
        height *= sizeUp
    }

    override fun rotate(direction: RotateDirection, centerX: Int, centerY: Int) {
        if (centerX == x && centerY == y) return
        if (direction == RotateDirection.Clockwise) x = y - centerY + centerX.also {
            y = -1 * (x - centerX) + centerY
        }
        if (direction == RotateDirection.CounterClockwise) x =
            -1 * (y - centerY) + centerX.also { y = x - centerX + centerY }
    }

    override fun move(dx: Int, dy: Int) {
        x += dx; y += dy
    }

    override fun area(): Float {
        return (width * height).toFloat()
    }
}