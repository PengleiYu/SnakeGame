import java.util.*

class Snake {
    val body: LinkedList<Node> = LinkedList()

    fun eat(food: Node): Node? {
        // 如果food与头部相邻，则将food这个Node加入到body中，返回food
        // 否则不做任何操作，返回null
        return if (isNeighbor(body.first, food)) {
            body.addFirst(food)
            food
        } else null
    }

    fun getHead(): Node = body.first

    fun addTail(area: Node): Node {
        body.addLast(area)
        return area
    }

    fun move(direction: Direction): Node {
        val head = body.first
        val newHead = when (direction) {
            Direction.UP -> head.copy(y = head.y - 1)
            Direction.DOWN -> head.copy(y = head.y + 1)
            Direction.LEFT -> head.copy(x = head.x - 1)
            Direction.RIGHT -> head.copy(x = head.x + 1)
        }
        body.addFirst(newHead)
        return body.removeLast()
    }

    fun hitSelf(): Boolean = body.filter { it == body.first }.size > 1

    private fun isNeighbor(a: Node, b: Node) = Math.abs(a.x - b.x) + Math.abs(a.y - b.y) == 1
}