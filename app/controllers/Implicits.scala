package controllers

import play.api.mvc.PathBindable

import java.time.LocalDate
import java.time.format.DateTimeFormatter

object Implicits {
  implicit def pathStringLocalDateBinder: PathBindable[LocalDate] = new PathBindable[LocalDate] {
    val dtf: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")

    override def bind(key: String, value: String): Either[String, LocalDate] = {
      try {
        val localDate = LocalDate.parse(value, dtf)
        Right(localDate)
      } catch {
        case e: IllegalArgumentException => Left("Failed to parse path string as LocalDate.")
      }
    }

    override def unbind(key: String, localDate: LocalDate): String = {
      localDate.format(dtf)
    }
  }
}
