/**
  * Created by yjlee on 2017-03-26.
  */
import akka.actor.{Props, IO, IOManager, Actor, ActorSystem}
import java.net.InetSocketAddress

 class TCPEchoServer(port: Int) extends Actor {
     override def preStart {
         IOManager(context.system).listen( new InetSocketAddress(port) )
       }


     def receive = {
         case IO.NewClient(server) => server.accept()
         case IO.Read(rHandle, bytes) => rHandle.asSocket.write(bytes.compact)
       }
   }


 object TCPEchoServer extends App {
     val port = Option(System.getenv("PORT")).map(_.toInt).getOrElse(9999)
     ActorSystem().actorOf(Props(new TCPEchoServer(port)))
  }

