import java.time.temporal.TemporalAmount

/**
 * Created by spatel on 5/20/2016.
 */
object Money {
  def main(args: Array[String]): Unit = {
    println(Money(12) + Money(34))
    val numbers = 1 :: 2 :: 3 :: 4 :: Nil
    numbers.foreach { n => println(n) }
    val sum = numbers.foldRight(0) { (total, element) => total + element }
    println(sum)

    def increment = (x: Int) => x + 2

    numbers.map(increment).foreach { n => println(n) }
  }

}

case class Money(val amount: Int = 1, val currency: String = "USD") {


  def +(other: Money): Money = Money(amount + other.amount)
}
