import org.junit.Test

class DirectionTest {
    @Test
    fun compatibleWith() {
        assert(Direction.UP.compatibleWith(Direction.UP))
        assert(!Direction.UP.compatibleWith(Direction.DOWN))
        assert(Direction.UP.compatibleWith(Direction.LEFT))
        assert(Direction.UP.compatibleWith(Direction.RIGHT))
        assert(!Direction.DOWN.compatibleWith(Direction.UP))
        assert(Direction.DOWN.compatibleWith(Direction.DOWN))
        assert(Direction.DOWN.compatibleWith(Direction.LEFT))
        assert(Direction.DOWN.compatibleWith(Direction.RIGHT))
        assert(Direction.LEFT.compatibleWith(Direction.UP))
        assert(Direction.LEFT.compatibleWith(Direction.DOWN))
        assert(Direction.LEFT.compatibleWith(Direction.LEFT))
        assert(!Direction.LEFT.compatibleWith(Direction.RIGHT))
        assert(Direction.RIGHT.compatibleWith(Direction.UP))
        assert(Direction.RIGHT.compatibleWith(Direction.DOWN))
        assert(!Direction.RIGHT.compatibleWith(Direction.LEFT))
        assert(Direction.RIGHT.compatibleWith(Direction.RIGHT))
    }

    @Test
    fun getDirectionCode() {
        println(2 shr 1 xor (0 shr 1))
    }
}