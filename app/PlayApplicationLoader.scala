import _root_.controllers.AssetsComponents
import com.softwaremill.macwire._
import play.api.ApplicationLoader.Context
import play.api._
import play.api.i18n._
import play.api.mvc.EssentialFilter
import play.api.routing.Router
import play.filters.HttpFiltersComponents
import play.filters.cors.CORSComponents
import router.Routes

import scala.concurrent.ExecutionContext

class PlayApplicationLoader extends ApplicationLoader {
  def load(context: Context): Application = new PlayComponents(context).application
}

class PlayComponents(context: Context) extends BuiltInComponentsFromContext(context)
  with AssetsComponents
  with I18nComponents
  with HttpFiltersComponents
  with CORSComponents
  with IndexModule {

  LoggerConfigurator(context.environment.classLoader).foreach {
    _.configure(context.environment, context.initialConfiguration, Map.empty)
  }
  val logger: Logger = Logger(this.getClass)

  logger.info("googleCredentialsをダンプします===============")

  override def httpFilters: Seq[EssentialFilter] = super.httpFilters :+ corsFilter

  implicit val ec: ExecutionContext = scala.concurrent.ExecutionContext.Implicits.global

  lazy val router: Router = {
    // add the prefix string in local scope for the Routes constructor
    val prefix: String = "/"
    wire[Routes]
  }
}