package Model.Animals

import Model.{Command, PackAnimal, PetCommands}

import java.util
import java.util.Date

class Horse(private var name: String, private var dateOfBirth: Date,
                 private val petCommands: PetCommands[Command]) extends PackAnimal(name, dateOfBirth, petCommands) {
  def this(name: String, dateOfBirth: Date) = this(name, dateOfBirth, new PetCommands[Command](new util.LinkedList()))

  override def toString: String = {
    s"Horse { name: $name, dateOfBirth: $dateOfBirth }"
  }
}
