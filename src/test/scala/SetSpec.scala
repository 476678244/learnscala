import org.scalatest._
import org.scalatest.matchers._

class SetSpec extends FreeSpec with GivenWhenThen with ShouldMatchers{
		"A Set" -{
			"New set should be empty" in {
				given("new set")
				var set = Set()
				then("new set should be empty")
				assert(set.isEmpty)
				and("size is 0")
				set.size should be (0)
			}

			"Set add element" in {
				given("a new set")
				var s = Set[Int]()
				when("add 1 element to set")
				s += 1
				then("set not empty")
				assert(!s.isEmpty)
				and("set size should be 1")
				s.size should be (1)
			}

			"Set can be filter index" in {
				given("New Set[Int] from 1 to 10 number")
				var x = Set[Int]()
				(1 to 10).map( x+=_)
				when("filter set and mod by 2")
				var b = x.filter(_ %2 ==0)
				then("have a new set")
				assert(null != b)
				and("new set is size")
				b.size should be (5)
				and("new set contains 2,4,6,8,10")
				assert(b.contains(2))
				assert(b.contains(4))
				assert(b.contains(6))
				assert(b.contains(8))
				assert(b.contains(10))
			}

			"Set to List" in {
				given("New Set[Int] as x")
				var x = Set[Int]()
				when("use to List to y")
				var y = x.toList
				then("y is be the same instance as x")
				y should be theSameInstanceAs (x.toList)
			}

			
		}

}