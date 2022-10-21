package domain.todo

import domain.Repository
import domain.todo.{Todo => TodoEntity}
import slick.basic.DatabaseConfig
import slick.jdbc.JdbcProfile
import slick.Tables._

import scala.concurrent.{ExecutionContext, Future}

class TodoRepository(dbConfig: DatabaseConfig[JdbcProfile])(override implicit val ec: ExecutionContext) extends Repository[ID, TodoEntity] {
  import profile.api._

  override def save(entity: TodoEntity): Future[TodoEntity] = ???

  override def saveAll(entities: Seq[TodoEntity]): Future[Seq[TodoEntity]] = ???

  override def delete(id: ID): Unit = ???

  override def deleteAll: Unit = ???

  override def find(id: ID): Future[Option[TodoEntity]] = ???

  override def findAll: Future[Seq[TodoEntity]] = ???
}
