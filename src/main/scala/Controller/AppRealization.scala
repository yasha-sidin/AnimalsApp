package Controller

import Model.Animals.{Camel, Cat, Dog, Donkey, Hamster, Horse}
import Model.AnimalsStorage.AnimalsStorage
import Model.{Animal, Command, Pet}

import java.util.Date
import java.util
import scala.annotation.tailrec
import scala.util.{Try, Using}
trait AppRealization {

  private val storage = new AnimalsStorage();

  private val counter = new Counter;

  def addNewAnimal(name: String, dateOfBirth: Date, animalType: String): Unit = {
    try {
      var animal: Animal = null;
      if (animalType.toUpperCase() == "CAT") {
        animal = new Cat(name, dateOfBirth);
      }
      if (animalType.toUpperCase() == "DOG") {
        animal = new Dog(name, dateOfBirth);
      }
      if (animalType.toUpperCase() == "HAMSTER") {
        animal = new Hamster(name, dateOfBirth);
      }
      if (animalType.toUpperCase() == "CAMEL") {
        animal = new Camel(name, dateOfBirth);
      }
      if (animalType.toUpperCase() == "DONKEY") {
        animal = new Donkey(name, dateOfBirth);
      }
      if (animalType.toUpperCase() == "HORSE") {
        animal = new Horse(name, dateOfBirth);
      }
      storage.addAnimal(animal);
      val count: Try[Unit] = Using(counter) { counts =>
        counter.addCount();
      }
    } catch {
      case e: MatchError => println("Please choose the correct class name. ");
      case e: Exception => println("Exception: " + e.toString);
    }
  }

  def getAllAnimals: util.LinkedList[Animal] = {
    val animalsList = new util.LinkedList[Animal]();
    animalsList.addAll(storage.getPackAnimals);
    animalsList.addAll(storage.getPets);
    animalsList;
  }

  def getPackAnimals: util.LinkedList[Animal] = {
    storage.getPackAnimals;
  }

  def getPets: util.LinkedList[Animal] = {
    storage.getPets;
  }

  def getAnimalByName(name: String): Animal = {
    val animalsList = getAllAnimals;
    val size = animalsList.size() - 1;
    @tailrec
    def loopFind(i: Int = size, acc: String = name): Animal = {
      if (i < 0) return null;
      if (animalsList.get(i).getName.equals(acc)) return animalsList.get(i);
      loopFind(i - 1, acc);
    }
    loopFind();
  }

  def getCommandByName(animal: Animal, commandName: String): Command = {
    val commandsList = animal.getPetCommands.getCommands;
    val size = commandsList.size();
    @tailrec
    def loopFind(i: Int = size - 1, acc: String = commandName): Command = {
      if (i < 0) return null;
      if (commandsList.get(i).getName.equals(acc)) return commandsList.get(i);
      loopFind(i - 1, acc);
    }
    loopFind();
  }

  private def stringListElements[T](list: util.LinkedList[T], char: Char = ' '): String = {
    var index = 0;
    var charString: String = char.toString;
    if (charString == " ") {
      charString = "";
    }
    @tailrec
    def loop(i: Int = list.size() - 1, acc: String = charString + list.get(index).toString + '\n'): String = {
      index = index + 1;
      if (i == 0) return acc;
      loop(i - 1, acc + charString + charString + charString + list.get(index).toString + '\n');
    }
    loop();
  }

  def stringPackAnimals: String = {
    if (getPackAnimals.isEmpty) {
      return "None\n";
    }
    stringListElements(getPackAnimals);
  }

  def stringPets: String = {
    if (getPets.isEmpty) {
      return "None\n";
    }
    stringListElements(getPets);
  }

  def stringCommands(animal: Animal): String = {
    val commands = animal.getPetCommands.getCommands;
    if (commands.isEmpty) {
      return "\tNone";
    }
    stringListElements(commands, '\t');
  }

  def getCounterNum: Int = {
    counter.getCounter;
  }
}