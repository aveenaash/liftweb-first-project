package code.model

import net.liftweb.mapper._
import net.liftweb.util._
import net.liftweb.common._

object ToDo extends ToDo with LongKeyedMetaMapper[ToDo]

class ToDo extends LongKeyedMapper[ToDo]
{
  def getSingleton = ToDo

  def primaryKeyField = id
  object id extends MappedLongIndex(this)
  object done extends MappedBoolean(this)
  //object owner extends MappedLongForeignKey(this,User)
  object priority extends MappedInt(this)
  {
    override def defaultValue = 5
  }
  //object desc extends MappedPoliteString(this)

}

