import java.awt.Color
import java.awt.Graphics
import javax.swing.JPanel

class GameView(private val grid: Grid) {
    val gameCanvas: JPanel

    init {
        gameCanvas = object : JPanel() {
            override fun paintComponent(g: Graphics) {
                drawGridBackground(g, grid)
                drawSnake(g, grid.getSnake())
                drawFood(g, grid.getFood())
            }
        }
    }

    fun draw() {
        gameCanvas.repaint()
    }

    private fun drawSnake(graphics: Graphics, snake: Snake) {
        snake.body.forEach { drawSquare(graphics, it, Color.RED) }
    }

    private fun drawFood(graphics: Graphics, food: Node) {
        drawSquare(graphics, food, Color.BLUE)
    }

    private fun drawGridBackground(graphics: Graphics, grid: Grid) {
        (0 until grid.width).forEach { i ->
            (0 until grid.height).forEach { j -> drawSquare(graphics, Node(i, j), Color.GRAY) }
        }
    }

    private fun drawSquare(graphics: Graphics, node: Node, color: Color) {
        graphics.color = color
        val size = Settings.DEFAULT_NODE_SIZE
        graphics.fillRect(node.x * size, node.y * size, size - 1, size - 1)
    }

    private fun drawCircle(graphics: Graphics, node: Node, color: Color) {
        graphics.color = color
        val size = Settings.DEFAULT_NODE_SIZE
        graphics.fillOval(node.x * size, node.y * size, size - 1, size - 1)
    }
}