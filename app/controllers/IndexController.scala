package controllers

import domain.todo.TodoRepository
import play.api.Logger
import play.api.i18n.Langs
import play.api.libs.json.Json
import play.api.mvc.{AbstractController, Action, AnyContent, ControllerComponents}

class IndexController(langs: Langs,
                      cc: ControllerComponents,
                      repository: TodoRepository) extends AbstractController(cc) {
  val logger: Logger = Logger(this.getClass)

  def index: Action[AnyContent] = Action {
    logger.error("errorレベルのログです")
    logger.warn("warnレベルのログです")
    logger.info("infoレベルのログです")
    logger.debug("debugレベルのログです")
    logger.trace("traceレベルのログです")

    Ok(Json.toJson("IndexController/index"))
  }
}
