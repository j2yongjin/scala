import scala.collection.mutable

/**
  * Created by yjlee on 2017-03-26.
  */
object StackSample {

  def main(args: Array[String]): Unit = {

    val stack = new mutable.Stack[Int]
    stack.push(1)
    stack.push(2)

    println(stack.pop())


  }

}
