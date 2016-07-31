/**
 * Created by spatel on 7/29/2016.
 */
object QuickSortFunctionalVsProcedural {

  /**
   * Perform procedural quick sort
   * @param array
   * @return
   */
  def proceduralQuickSort(array: Array[Int]): Array[Int] = {

    /**
     * Swap the value between 2 location
     * @param i
     * @param j
     */
    def swap(i: Int, j: Int): Unit = {
      val temp = array(i)
      array(i) = array(j)
      array(j) = temp
    }

    /**
     * Perform the quickSort on portion of array between the 2 provided index
     * @param leftIndex
     * @param rightIndex
     */
    def quickSort(leftIndex: Int, rightIndex: Int) {

      val pivot = array((leftIndex + rightIndex) / 2)
      //      println("leftIndex - " + leftIndex)
      //      println("rightIndex - " + rightIndex)
      //      println("index - " + (leftIndex + rightIndex) / 2)
      //      println("pivot - " + pivot)
      var leftTempIndex = leftIndex
      var rightTempIndex = rightIndex

      // loop through till the left pointer does not cross the right pointer.
      while (leftTempIndex <= rightTempIndex) {

        // identify the first element on left side of pivot which greater than pivot
        while (array(leftTempIndex) < pivot) leftTempIndex += 1

        // identify the first element on right side of pivot which less than pivot
        while (array(rightTempIndex) > pivot) rightTempIndex -= 1

        // if left pointer is still less than right pointer, the swamp the above 2 element.
        if (leftTempIndex <= rightTempIndex) {
          swap(leftTempIndex, rightTempIndex)
          leftTempIndex += 1
          rightTempIndex -= 1
        }
      }

      //      array.foreach(n => print(n + ","))
      //      readLine()

      //repeat this for left and right half of the array.
      if (leftIndex < rightTempIndex) quickSort(leftIndex, rightTempIndex)
      if (leftTempIndex < rightIndex) quickSort(leftTempIndex, rightIndex)


    }

    quickSort(0, array.length - 1)

    //    println
    return array
  }

  /**
   * Perform functional quick sort
   * @param array
   * @return
   */
  def functionalQuickSort(array: Array[Int]): Array[Int] = {
    if (array.length <= 1) array
    else {
      val pivot = array(array.length / 2)
      Array.concat(functionalQuickSort(array filter (pivot >)), array filter (pivot ==), functionalQuickSort(array filter (pivot <)))
    }
  }

  def main(args: Array[String]): Unit = {

    val arraySize = Array(10, 100, 1000, 10000, 100000, 1000000, 50000000)

    for (i <- arraySize) {

      // initialize array with random int value from 0 to 9
      val intArray = Array.fill(i) {
        scala.util.Random.nextInt(i - 1)
      }

      println("**********************************")
      println("array size - " + i)
      //    println("Orginal Array")
      //    intArray.foreach { n => print(n + ",") }
      //    println

      //      println("**********************************")
      //      readLine()
      var t1 = System.currentTimeMillis()
      val intSortedArray1 = functionalQuickSort(intArray)
      var t2 = System.currentTimeMillis()
      println("Functional Sort Time : " + (t2 - t1))
      //    println("Sorted Array")
      //    intSortedArray1.foreach { n => print(n + ",") }
      //    println

      //      println("**********************************")
      //      readLine()
      var t3 = System.currentTimeMillis()
      val intSortedArray2 = proceduralQuickSort(intArray)
      var t4 = System.currentTimeMillis()
      println("Procedural Sort Time : " + (t4 - t3))
      //    println("Sorted Array")
      //    intSortedArray2.foreach { n => print(n + ",") }
      //    println

      //      readLine()
    }
  }
}
