package domain.todo

import domain.{Entity, Identifier}

import java.time.LocalDateTime

case class ID(value: String) extends Identifier[String]
case class 内容(value: String) extends Identifier[String]
case class createdAt(value: LocalDateTime) extends Identifier[LocalDateTime]

case class Todo(id: ID, 内容: 内容, createdAt: createdAt) extends Entity[ID]
