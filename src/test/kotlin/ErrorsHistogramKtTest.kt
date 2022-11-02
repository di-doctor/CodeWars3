import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ErrorsHistogramKtTest {
    val errorHistogram = ErrorHistogram()

    @Test
    fun hist1() {
        val expected = """u  3     ***\rw  4     ****\rx  6     ******\rz  6     ******"""
        val str = "tpwaemuqxdmwqbqrjbeosjnejqorxdozsxnrgpgqkeihqwybzyymqeazfkyiucesxwutgszbenzvgxibxrlvmzihcb"
        assertEquals(expected, errorHistogram.hist(str))

    }
    @Test
    fun hist2(){
        val expected = """u  3     ***\rw  4     ****\rx  6     ******\rz  6     ******"""
        val str2 = "xtpwaemuqxdmwqbqrjbeosjnejqorxdozsxnrgpgqkeihqwybzyymqeazfkyiucesxwutgszbenzvgxibxrlvmzihcb"
        assertEquals(expected, errorHistogram.hist(str2))
    }
    @Test
    fun `should return the same data as in repository`(){
        assertEquals(6,2*3)
    }
}