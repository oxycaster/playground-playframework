import domain.todo.TodoRepository
import play.api.db.slick.{DbName, SlickComponents}
import slick.jdbc.JdbcProfile

import scala.concurrent.ExecutionContext

trait RepositoryModule extends SlickComponents {
  import com.softwaremill.macwire._

  implicit def ec: ExecutionContext
  lazy val dbConf = slickApi.dbConfig[JdbcProfile](DbName("default"))

  lazy val TodoRepository: TodoRepository = wire[TodoRepository]
}
