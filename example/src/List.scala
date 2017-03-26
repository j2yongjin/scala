/**
  * Created by yjlee on 2017-03-26.
  */
object ListSample {


  //스칼라의 배열이 값을 변경 할 수 있는 순서가 정해진 시퀀스라면
  // 스칼라의 리스트는 기본적으로  값을 변경 할 수 없는 시퀀스입니다.


  def main(args: Array[String]): Unit = {

      val list = List(1,2,3)

      println(list(0))

      list.foreach( (x:Int) => println(x) )

      list.map( (x:Int) => x*x ).foreach( (y:Int) => println(y))

      list.map( (x:Int) => x*x*x ).filter( (y:Int) =>  y>9).foreach( (z:Int) => println(z))

      val range = List.range(1,10)

      println(range(5))

      var fill  = List.fill(2)("yjlee")

      println(fill(1))

      var sumList = range ::: fill


  }

  def count(all :Seq[String]) :Int = {
    var temp = 0;
    for ( one  <- all) {
      if(one.length == 4)
        temp = temp + 1

    }
    temp
  }

}
