package Model

class Command(private var name: String, private var realization: String) {

  def setName(new_name: String): Unit = {
    name = new_name;
  }

  def setRealization(new_realization: String): Unit = {
    realization = new_realization;
  }

  def getName(): Unit = {
    name
  }

  def getRealization(): Unit = {
    realization
  }
}
