import java.awt.BorderLayout
import java.awt.Dimension
import javax.swing.JFrame

class SnakeApp {

    fun init() {
        with(JFrame("贪吃蛇")) {
            preferredSize = Dimension(500, 500) //窗口大小
            val gameView = GameView(Grid(20, 20))
            contentPane.add(gameView.gameCanvas, BorderLayout.CENTER) //添加组件
            addKeyListener(GameController(gameView))
            isResizable = false //大小不可变
            defaultCloseOperation = JFrame.EXIT_ON_CLOSE //窗口关闭行为
            pack() //渲染
            isVisible = true //显示
        }
    }
}
