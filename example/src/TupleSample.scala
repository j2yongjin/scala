/**
  * Created by yjlee on 2017-03-26.
  */
object TupleSample {



  //리스트와 마찬가지로 변경 불가능 하다.
  //* 리스트와 다른 점은 다른 타입의 원소를 넣을 수 있다는 점
  //* 메소드에서 여러 다양한 객체를 리턴해야 하는 경우

  def main(args: Array[String]): Unit = {

    var tuple11 = (37,"yjlle")

    println(tuple11._1)
    println(tuple11._2)

  }

}
