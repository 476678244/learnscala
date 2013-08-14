import org.scalatest._

class ListSpec extends FlatSpec with GivenWhenThen {
	
	def fixture = 
		new {
			val l = List(1,2,3,4,5)
	}
		

	it should "found element 5 " in {
		val f = fixture
		given("a list")

		when("contains value in list")
		var found = f.l.contains(5)

		then("found in list")
		assert(found)
	}

	it should "found when add new element" in {
		
		given( "list ")
		val l = List(1,2)
		when ("add 10 to list")
		var x = 10::l
		then ("contains 10")
		assert(x.contains(10))
	}

	it should "be new list when merge 2 list" in {
		given ("2 list")
		val l1 = List(1,2)
		val l2 = List(3,4)
		when("l3 is l1 merge with l2")
		val l3 = l1:::l2

		then("l3 is contains value same on l1 and l2")
		assert(l3.contains(1))
		assert(l3.contains(2))
		assert(l3.contains(3))
		assert(l3.contains(4))

	}
}