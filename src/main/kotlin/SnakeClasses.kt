enum class Direction(private val directionCode: Int) {
    UP(0), DOWN(1), LEFT(2), RIGHT(3);

    /**
     * 是否可以转到新方向
     */
    fun compatibleWith(newDirection: Direction): Boolean {
        return this == newDirection ||
                (directionCode shr 1) xor (newDirection.directionCode shr 1) == 1
    }
}

data class Node(val x: Int, val y: Int)

class Settings {
    companion object {
        const val DEFAULT_NODE_SIZE = 20
        const val DEFAULT_GRID_WIDTH = 20
        const val DEFAULT_GRID_HEIGHT = 20
        const val DEFAULT_VIEW_WIDTH = DEFAULT_GRID_WIDTH * DEFAULT_NODE_SIZE
        const val DEFAULT_VIEW_HEIGHT = DEFAULT_GRID_HEIGHT * DEFAULT_NODE_SIZE
        const val DEFAULT_MOVE_INTERVAL = 500L
    }
}