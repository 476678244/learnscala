import org.scalatest._
import org.scalatest.matchers._
class ArraySpec extends FreeSpec with GivenWhenThen with ShouldMatchers {
	"An Array" - {
		"New Array is empty" in {
			given("New Array[String] as var x") 
			var x = Array[String]()
			then("x is empty")
			assert(x.isEmpty)
			and("x is size equals 0")
			x.size should be (0)
		}
	}
}