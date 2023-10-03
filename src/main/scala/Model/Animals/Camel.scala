package Model.Animals

import Model.{Command, PackAnimal, PetCommands}

import java.text.SimpleDateFormat
import java.util
import java.util.Date

class Camel(private var name: String, private var dateOfBirth: Date,
            private val petCommands: PetCommands) extends PackAnimal(name, dateOfBirth, petCommands) {
  def this(name: String, dateOfBirth: Date) = this(name, dateOfBirth, new PetCommands(new util.LinkedList()))

  override def toString: String = {
    val formatter = new SimpleDateFormat("dd.MM.yyyy");
    s"Camel { name: $name, dateOfBirth: ${formatter.format(dateOfBirth)} }"
  }
}