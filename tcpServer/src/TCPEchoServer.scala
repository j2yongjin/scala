/**
  * Created by yjlee on 2017-03-26.
  */

import akka.actor.IO._
import akka.actor.{Props, IO, IOManager, Actor, ActorSystem}
import akka.event.Logging
import akka.util.ByteString
import java.net.InetSocketAddress

class TCPEchoServer(port: Int) extends Actor {
     val log = Logging(context.system, this)

     val state = IterateeRef.Map.async[IO.Handle]()(context.dispatcher)

     override def preStart {
       IOManager(context.system).listen( new InetSocketAddress(port) )
     }

     def receive = {
         case NewClient(server) => {
             log.info("new client")
             val socket = server.accept()
             state(socket) flatMap (_ => this.write(socket))
           }
         case Read(socket, bytes) => {
             state(socket)(Chunk(bytes))
           }
         case Closed(socket, cause) => {
             //state(socket)(EOF(None))
             state -= socket
               log.info("socket closed")
           }
       }


     def ascii(bytes: ByteString): String = bytes.decodeString("US-ASCII")


     def write(socket: IO.SocketHandle): IO.Iteratee[Unit] =
       IO.repeat {
           for {
               string <- readLine
           } yield {
             log.info(string)
             socket.write(ByteString(string))
           }
       }
     def readLine: IO.Iteratee[String] = {
         val CRLF = ByteString("\r\n")
         for {
             line <- IO.takeUntil(CRLF)
           } yield {
             ascii(line)
           }
       }
   }



object Main extends App {
     val port = Option(System.getenv("PORT")).map(_.toInt).getOrElse(9999)
     ActorSystem().actorOf(Props(new TCPEchoServer(port)))
   }

