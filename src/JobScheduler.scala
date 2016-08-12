import scala.collection.JavaConverters._

/**
 * Created by spatel on 8/9/2016.
 */
object JobScheduler {

  def main(args: Array[String]): Unit = {

    var jobMem = List[Int](10, 5, 5, 10, 5, 5, 10).sortWith(_ > _)
    var serverMem = List[Int](20, 15, 10, 5).sortWith(_ > _)

    if (checkIfAllJobsExecute(jobMem, serverMem)) {
      println("Can be executed")
    } else {
      println("Cannot be executed")
    }

  }

  def checkIfAllJobsExecute(jobMem: List[Int], serverMem: List[Int]): Boolean = {

    var jobCanBeExecuted = false

    for (i <- 0 to jobMem.length-1) {

      jobCanBeExecuted = false

      for (j <- 0 to serverMem.length-1) {

        if (jobMem(i) <= serverMem(j) && !jobCanBeExecuted) {
          serverMem(j) = serverMem(j) - jobMem(i)
          jobCanBeExecuted = true
        }
      }

      if (!jobCanBeExecuted) return jobCanBeExecuted

    }

    return true
  }
}