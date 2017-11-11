/**
  * Created by spatel on 4/16/2017.
  */
object SquareRoot {

  def abs(x: Double) = if (x < 0) -x else x

  def sqrt(x: Double): Double = {

    def sqrtIter(guess: Double): Double =
      if (isGoodEnough(guess)) guess
      else sqrtIter(improve(guess))

    def isGoodEnough(guess: Double): Boolean = abs(guess * guess - x) < (x * .001)

    def improve(guess: Double): Double = (guess + x / guess) / 2


    sqrtIter(1.0)
  }

  def main(args: Array[String]): Unit = {
    println(sqrt(2));
    println(sqrt(.001));
    println(sqrt(0.1e-20));
    println(sqrt(1e20));
    println(sqrt(1e50));
  }

}
