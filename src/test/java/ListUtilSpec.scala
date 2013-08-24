import org.scalatest._
import util._
import org.scalatest.matchers._
class ListUtilSpec extends FunSuite with GivenWhenThen with ShouldMatchers{
	var l = ListUtil()

	test("Add some value") {
		
		given("value a")
		var a = 1
		when("'add' a to ListUtil")
		l.add(1)
		then("list size equals 1")
		assert(l.size == 1)


	}

	test("Display value") {
		given("value b")
		var b = 2
		when("add b to ListUtil")
		l.add(b)
		then("list util contains b")
		assert(l.contains(b))
	}
}