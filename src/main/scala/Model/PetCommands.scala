package Model

import java.util
class PetCommands[Command](private val commands: util.LinkedList[Command]) {
  def getCommands(): util.LinkedList[Command] = {
    commands;
  }

  def addCommand(command: Command): Unit = {
    commands.addLast(command)
  }
}
