package Model.Animals

import Model.{Command, Pet, PetCommands}

import java.util
import java.util.Date

class Hamster(private var name: String, private var dateOfBirth: Date,
              private val commands: PetCommands[Command]) extends Pet(name, dateOfBirth, commands) {
  def this(name: String, dateOfBirth: Date) = this(name, dateOfBirth, new PetCommands[Command](new util.LinkedList()));

  override def toString: String = {
    s"Hamster { name: $name, dateOfBirth: $dateOfBirth }"
  }
}
