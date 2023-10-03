package Model.Animals

import Model.{Command, Pet, PetCommands}

import java.text.SimpleDateFormat
import java.util
import java.util.Date

class Cat(private var name: String, private var dateOfBirth: Date,
          private val commands: PetCommands) extends Pet(name, dateOfBirth, commands) {
  def this(name: String, dateOfBirth: Date) = this(name, dateOfBirth, new PetCommands(new util.LinkedList()))

  override def toString: String = {
    val formatter = new SimpleDateFormat("dd.MM.yyyy");
    s"Cat { name: $name, dateOfBirth: ${formatter.format(dateOfBirth)} }"
  }
}

