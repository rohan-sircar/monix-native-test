package example
import monix.eval.TaskApp
import monix.eval.Task
import cats.effect.ExitCode
import cats.syntax.all._
import monix.catnap.ConcurrentQueue

object MonixHello extends TaskApp {
  val program = for {
   _ <- Task(println("Hello from Monix!"))
   queue <- ConcurrentQueue[Task].bounded[Int](10)
   _ <- queue.offer(1)
  } yield ()
  def run(args: List[String]) = program.as(ExitCode.Success)
}
