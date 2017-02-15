package org.zonghan.testtype

/**
  * Created by wuzonghan on 17/2/15.
  */
object TestType2 extends App {
  class Covariant[+A]

  val cv: Covariant[AnyRef] = new Covariant[String]

  class Contravariant[-A]

  val cv2: Contravariant[String] = new Contravariant[AnyRef]

  class Animal { val sound = "rustle" }

  class Bird extends Animal { override val sound = "call" }

  class Chicken extends Bird { override val sound = "cluck" }

  val getTweet: (Bird => String) = ((a: Animal) => a.sound )

  val hatch: (() => Bird) = (() => new Chicken )

  def biophony[T <: Animal](things: Seq[T]) = things map (_.sound)
  println(biophony(Seq(new Chicken, new Bird)))

  val flock = List(new Bird, new Bird)
  println(((new Animal) :: flock).getClass)
  println(((new Chicken) :: flock).getClass)

}
