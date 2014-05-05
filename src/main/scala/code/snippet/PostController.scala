package code.snippet

import net.liftweb.util.Helpers._
import net.liftweb.http.SHtml.{text,textarea,onSubmitUnit,checkbox}
import net.liftweb.http.SHtml
import net.liftweb.common.Loggable
import xml.Text
import net.liftweb.http.S
import net.liftweb.common._

import code.model.Post

class PostController extends Loggable
{

  def render = {
    var title =""
    var content = ""
    var published : Boolean = false

    def processRequest() = {

      // the folowing code saves forms data to database using mapper orm
      val myPost :Post = Post.create
      myPost.title(title)
      myPost.content(content)
      myPost.published(published)
      val saved : Boolean = myPost.save

      S.notice("Saved "+ saved)
    }

    "@title" #>text(title,s=> title = s) &
    "@content" #>textarea(content, s => content = s) &
     "@published" #> checkbox(published, (s) => published = s) &
      "@postsubmit" #> onSubmitUnit(processRequest)
  }
}