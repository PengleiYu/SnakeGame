import java.util.*

class Grid(val width: Int, val height: Int) {
    public val status: Array<BooleanArray> = Array(height) { BooleanArray(width) }
    private var snakeDirection = Direction.LEFT
    private var snake: Snake
    private var food: Node

    init {
        snake = initSnake()
        food = createFood(snake)
    }

    fun changeDirection(direction: Direction) {
        //检查方向是否可改变
        if (snakeDirection.compatibleWith(direction))
            snakeDirection = direction
    }

    fun nextRound(): Boolean {
        val tail = snake.move(snakeDirection)//移动
        return if (isValid(snake.getHead())) {//蛇头是否非法
            if (snake.getHead() == food) {
                //蛇头是食物，则尾部再加回去，并生产新食物
                snake.addTail(tail)
                food = createFood(snake)
            }
            true
        } else false
    }

    fun getSnake(): Snake = snake
    fun getFood(): Node = food

    /**
     * 蛇头是否超出边界
     */
    private fun isValid(node: Node): Boolean {
        return node.x in 0..(width - 1) && node.y in 0..(height - 1)
    }

    private fun initSnake(): Snake {
        snake = Snake()
        val x: Int = width / 2
        val y: Int = height / 2
        (0..3).map { snake.addTail(Node(x + it, y)) }
        return snake
    }

    /**
     * 创建食物，保证不会出现在蛇身上
     */
    private fun createFood(snake: Snake): Node {
        val random = Random()
        do {
            food = Node(random.nextInt(width), random.nextInt(height))
        } while (snake.body.contains(food))
        return food
    }
}
