import java.awt.BorderLayout
import java.awt.Dimension
import javax.swing.JFrame

class SnakeApp {

    fun init() {
        with(JFrame("贪吃蛇")) {
            val grid = Grid(Settings.DEFAULT_GRID_WIDTH, Settings.DEFAULT_GRID_HEIGHT)
            val gameView = GameView(grid).apply {
                gameCanvas.preferredSize =
                        Dimension(Settings.DEFAULT_VIEW_WIDTH, Settings.DEFAULT_VIEW_HEIGHT)
            }
            val controller = GameController(grid, gameView)
            contentPane.add(gameView.gameCanvas, BorderLayout.CENTER) //添加组件
            addKeyListener(controller)
            isResizable = false //大小不可变
            defaultCloseOperation = JFrame.EXIT_ON_CLOSE //窗口关闭行为
            pack() //渲染
            isVisible = true //显示
            Thread(controller).start()
        }
    }
}
