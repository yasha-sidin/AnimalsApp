package Model

import java.util
import java.util.Date
abstract class Pet(private var name: String, private var dateOfBirth: Date,
          private val commands: PetCommands) extends Animal(name, dateOfBirth, commands) {
  def this(name: String, dateOfBirth: Date) = this(name, dateOfBirth, new PetCommands(new util.LinkedList()))
}

