package Model

import java.util
class PetCommands(private val commands: util.LinkedList[Command]) {
  val namesList = new util.LinkedList[String]();

  def getCommands: util.LinkedList[Command] = {
    commands;
  }

  def addCommand(command: Command): Unit = {
    if (namesList.contains(command.getName)) {
      throw new RuntimeException("This name of command has already exists. Please choose other name. ");
    }
    commands.addLast(command);
    namesList.addLast(command.getName);
  }
}

