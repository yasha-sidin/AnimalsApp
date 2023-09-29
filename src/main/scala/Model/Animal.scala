package Model

import Model.Animal.namesList

import java.util
import java.util.Date

abstract class Animal(private var name: String,
                      private var dateOfBirth: Date, private val commands: PetCommands[Command]) {

  private val id = java.util.UUID.randomUUID.toString;

  if (name.length < 2) {
    throw new RuntimeException("Length of the animal's name must be more than 1 character. ");
  }

  if (namesList.contains(name)) {
    throw new RuntimeException("Please choose another name, because this has already occupied. ")
  }

  namesList.addLast(name);
  def this(name: String, dateOfBirth: Date) = {
    this(name, dateOfBirth, new PetCommands(new util.LinkedList()));
  }

  def getDateOfBirth(): Date = {
    this.dateOfBirth;
  }

  def setDateOfBirth(dateOfBirth: Date): Unit = {
    this.dateOfBirth = dateOfBirth;
  }

  def getName(): String = {
    this.name;
  }

  def setName(): Unit = {
    this.name = name;
  }

  def addCommand(command: Command) = {
    this.commands.addCommand(command);
  }

  def getId(): String = {
    this.id;
  }

  def getPetCommands(): PetCommands[Command] = {
    this.commands;
  }
}

object Animal {
  val namesList = new util.LinkedList[String]();
}
