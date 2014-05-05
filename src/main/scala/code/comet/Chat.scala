package code.comet

import net.liftweb.http._
import net.liftweb.util._


class Chat extends CometActor with CometListener
{
  private var msgs : Vector[String]= Vector()

    def registerWith = ChatServer

    def render = "li *" #> msgs & ClearClearable

    override def lowPriority = {
      case v : Vector[String] => msgs = v; reRender()
    }

}