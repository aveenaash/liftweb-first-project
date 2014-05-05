package code.snippet

import code.comet.ChatServer
import net.liftweb.http.SHtml
import net.liftweb.http.js.JsCmds.SetValById

object ChatIn{

  def render = {
    SHtml.onSubmit( s =>
                      {
                        ChatServer ! s
                        SetValById("chat_in","")
                      })
  }
}