package code.comet

import net.liftweb.http._
import net.liftweb.util._


class Chat extends CometActor with CometListener
{
  private var msgs : String= ""

    def registerWith = ChatServer

    def render = "textarea *" #> msgs

    override def lowPriority = {
      case v : String => msgs = v; reRender()
    }

}