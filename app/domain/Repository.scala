package domain

import scala.concurrent.{ExecutionContext, Future}

trait Repository[ID <: Identifier[_], E <: Entity[ID]] {
  implicit val ec: ExecutionContext

  def save(entity: E): Future[E]

  def saveAll(entities: Seq[E]): Future[Seq[E]]

  def delete(id: ID): Unit

  def deleteAll: Unit

  def find(id: ID): Future[Option[E]]

  def findAll: Future[Seq[E]]

}
