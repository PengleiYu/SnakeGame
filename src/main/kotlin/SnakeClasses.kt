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