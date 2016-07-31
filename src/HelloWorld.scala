import scala.math._

object HelloWorld {

  def main(args: Array[String]) : Unit = {
    for (i <- 0 to 10)
      println(fact(i))

    println(abs(-10))
  }


  def fact(x: Int): Int = {
    if (x > 1) return (x) * fact(x - 1)
    else return 1
  }


}