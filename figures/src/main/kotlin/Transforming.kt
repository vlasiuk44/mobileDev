interface Transforming {
    fun resize(sizeUp: Int)
    fun rotate(direction: RotateDirection, centerX: Int, centerY: Int)
}

enum class RotateDirection {
    Clockwise, CounterClockwise
}