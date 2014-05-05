package code.comet

import net.liftweb._
import net.liftweb.common.Full
import http._
import util._
import Helpers._
import net.liftweb.http.js.JsCmds.SetHtml

import _root_.scala.xml.Text

import java.util.Date



class Clock extends CometActor {
  override def defaultPrefix = Full("clk")
  def render = bind("time" -> timeSpan)

  def timeSpan = (<span id="time">{timeNow}</span>)
  // schedule a ping every 10 seconds so we redraw
  ActorPing.schedule(this, Tick, 10000L)
  override def lowPriority : PartialFunction[Any, Unit] = {
    case Tick => {
      println("Got tick " + new Date());
      partialUpdate(SetHtml("time", Text(timeNow.toString)))

      // schedule an update in 10 seconds
      ActorPing.schedule(this, Tick, 10000L)
    }
  }
}
case object Tick