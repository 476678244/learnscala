import org.scalatest._
import org.scalatest.matchers._
import scala.collection.mutable._
class MapSpec extends FreeSpec with GivenWhenThen with ShouldMatchers {
	val fixture = 
		new {
			var m = new HashMap[Int,String]()
		}
	"A Map" - {
		"New Map should be zero and empty" in {
			given("new map")
			val m = Map()

			then("map is empty")
			assert( true == m.isEmpty)

			and("map length should be 0")
			m.size should be (0)
		}

		"Add 1 element " in {
			var m = fixture.m
			given("1 key and 1 value")
			val key1 = 1
			val value = "value1"
			when("put key , value to map")
			m.put(key1,value)
			then("map size is 1")
			m.size should be (1)
			and("get map from key equals value")
			var valueCheck = m.get(1)
			"value1" should be equals(valueCheck)
			
		}
	}
}