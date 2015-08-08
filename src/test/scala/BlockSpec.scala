import org.scalatest._

class BlockSpec extends FlatSpec with ShouldMatchers {
	val block = new Block(2,2,2)

	it should "return when getWidth" in {
            block.getWidth should be (2)
	}
        it should "return when getHeight" in {
            block.getHeight should be (2)
        }
        it should "return when getLength" in {
            block.getLength should be (2)
        }
        it should "return value when getVolumn" in {
            block.getVolumn should be (8)
        }
        it should "return value when getSurfaceArea" in {
            block.getSurfaceArea should be (24)
        }

}

class Block(width: Int, length: Int, height: Int) {
	def getWidth: Int = {
            this.width  
	}
        def getHeight: Int = {
            this.height
        }
        def getLength: Int = {
            this.length
        }
        def getVolumn: Int = {
            (this.length * this.width * this.height )
        }
        def getSurfaceArea: Int = {
            2 * ( ( this.width * this.length) + (this.width * this.height) +
            ( this.length * this.height) )
        }
}
