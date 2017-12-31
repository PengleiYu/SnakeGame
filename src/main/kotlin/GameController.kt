import java.awt.event.KeyEvent
import java.awt.event.KeyListener

class GameController(private val grid: Grid, private val gameView: GameView) : KeyListener, Runnable {
    private var isRunning = true
    override fun keyTyped(e: KeyEvent?) {}
    override fun keyReleased(e: KeyEvent?) {}

    override fun keyPressed(e: KeyEvent) {
        println(e.keyCode)
        val direction: Direction = when (e.keyCode) {
            KeyEvent.VK_UP -> Direction.UP
            KeyEvent.VK_DOWN -> Direction.DOWN
            KeyEvent.VK_LEFT -> Direction.LEFT
            KeyEvent.VK_RIGHT -> Direction.RIGHT
            else -> return
        }
        grid.changeDirection(direction)
        gameView.draw()
    }

    override fun run() {
        while (isRunning){
            try {
                Thread.sleep(Settings.DEFAULT_MOVE_INTERVAL)
            }catch (e:InterruptedException){
                break
            }
            grid.nextRound()
            gameView.draw()
        }
        isRunning=false
    }
}
