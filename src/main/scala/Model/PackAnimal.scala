package Model

import java.util
import java.util.Date

abstract class PackAnimal(private var name: String, private var dateOfBirth: Date,
                 private val petCommands: PetCommands) extends Animal(name, dateOfBirth, petCommands) {
  def this(name: String, dateOfBirth: Date) = this(name, dateOfBirth, new PetCommands(new util.LinkedList()))
}
