package Controller

class Counter extends AutoCloseable {

  private var counter = 0;

  def addCount(): Unit = {
    counter = counter + 1;
  }

  def getCounter: Int = {
    counter;
  }
  override def close(): Unit = ???
}
