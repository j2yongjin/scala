/**
  * Created by yjlee on 2017-03-26.
  */
object  ArraySample {

  def main(args: Array[String]): Unit = {
    val arr = new Array[String](2)

    arr(0) = "hello world"
    arr(1) = "2017"
    print(arr(0))

    arr(1) = " 3월 26일"
    println(arr(1))

    var simpleArray = Array(" hello" , " world")

    println(simpleArray(0))
  }

}
