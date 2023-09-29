package Controller

import Model.Animals.{Camel, Cat, Dog, Donkey, Hamster, Horse}
import Model.AnimalsStorage.AnimalsStorage
import Model.{Animal, Command, Pet}

import java.util.Date
import java.util
import scala.annotation.tailrec
trait AppRealization {

  private val storage = new AnimalsStorage();

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
    } catch {
      case e: MatchError => System.err.println("Please choose the correct class name. ");
      case e: Exception => System.err.println("Exception: " + e.toString);
    }
  }

  def getAllAnimals: util.LinkedList[Animal] = {
    val animalsList = new util.LinkedList[Animal]();
    animalsList.addAll(storage.getPackAnimals());
    animalsList.addAll(storage.getPets());
    animalsList;
  }

  def getPackAnimals: util.LinkedList[Animal] = {
    storage.getPackAnimals();
  }

  def getPets: util.LinkedList[Animal] = {
    storage.getPets();
  }

  def getAnimalByName(name: String): Animal = {
    val animalsList = getAllAnimals;
    val size = animalsList.size() - 1;
    @tailrec
    def loopFind(i: Int = size, acc: String = name): Animal = {
      if (animalsList.get(i).getName().equals(acc)) return animalsList.get(i);
      if (i == 0) return null;
      loopFind(i - 1, acc);
    }
    loopFind();
  }
}

object App extends App with AppRealization {
  addNewAnimal("Gobi", new Date(), "Camel");
  println(getPackAnimals);
  println(getPets);
  println(getAllAnimals);
  println(getAnimalByName("Gobi"))
}