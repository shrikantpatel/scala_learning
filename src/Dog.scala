/**
 * Created by spatel on 6/17/2016.
 */
class Dog(br: String, nm: String) {

  var breed: String = br
  var name: String = nm

  def bark = "Woof, woof !"

  def run(speed: Int) = {
    println(name + " is running at speed of " + speed)
  }

  def cycleAndRun(test:() => Unit) {
    println("function being passed")
    test()
    println("cycle");
  }
}

object Dog {

  def main(args: Array[String]): Unit = {
    var dobarman = new Dog("dobarman", "big")
    dobarman.bark
    dobarman.run(10)
    dobarman.cycleAndRun(() => println("hello"))
  }
}
