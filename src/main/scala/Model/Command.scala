package Model

import java.util
class Command(private var name: String, private var realization: String) {
  if (name.length < 1 || realization.length < 1) {
    throw new RuntimeException("Amount of characters in name of command and in realization's string can't be less than 1 char. ");
  }
  def setName(new_name: String): Unit = {
    if (new_name.length < 1) {
      throw new RuntimeException("Amount of characters in name of command can't be less than 1 char. ");
    }
    name = new_name;
  }

  def setRealization(newRealization: String): Unit = {
    if (newRealization.length < 1) {
      throw new RuntimeException("Amount of characters in realization's string can't be less than 1 char. ");
    }
    realization = newRealization;
  }

  def getName: String = {
    name;
  }

  def getRealization: String = {
    realization;
  }

  override def toString: String = {
    s"Command { name: $name, realization: $realization)";
  }
  def execute = {
    println("---------------Command execution----------------");
    println(realization);
    println("---------------------Stop-----------------------")
  }
}
