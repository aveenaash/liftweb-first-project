package code.model

import net.liftweb.mapper._



class Post extends LongKeyedMapper[Post]
{
  def getSingleton = Post
  def primaryKeyField = id

  object id extends MappedLongIndex(this)
  object title extends MappedString(this,400)
  object content extends MappedText(this)
  object published extends MappedBoolean(this)
}

object Post extends Post with LongKeyedMetaMapper[Post]