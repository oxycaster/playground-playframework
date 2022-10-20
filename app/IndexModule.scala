import controllers.IndexController
import play.api.i18n.Langs
import play.api.mvc.ControllerComponents

trait IndexModule {
  import com.softwaremill.macwire._

  def langs: Langs
  def controllerComponents: ControllerComponents

  lazy val greeterController: IndexController = wire[IndexController]
}