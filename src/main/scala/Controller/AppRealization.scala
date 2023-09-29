package Controller

import Model.Animals.{Camel, Cat, Dog, Donkey, Hamster, Horse}
import Model.AnimalsStorage.AnimalsStorage
import Model.{Animal, Command, Pet}

import java.util.Date
import java.util
trait AppRealization {

  val storage = new AnimalsStorage();

  def addNewAnimal(name: String, dateOfBirth: Date, animalType: String): Unit = {
    try {
      var animal: Animal = null;
      if (animalType.toUpperCase() == "CAT") {
        animal = new Cat(name, dateOfBirth)
      }
      if (animalType.toUpperCase() == "DOG") {
        animal = new Dog(name, dateOfBirth)
      }
      if (animalType.toUpperCase() == "HAMSTER") {
        animal = new Hamster(name, dateOfBirth)
      }
      if (animalType.toUpperCase() == "CAMEL") {
        animal = new Camel(name, dateOfBirth)
      }
      if (animalType.toUpperCase() == "DONKEY") {
        animal = new Donkey(name, dateOfBirth)
      }
      if (animalType.toUpperCase() == "HORSE") {
        animal = new Horse(name, dateOfBirth)
      }

      storage.addAnimal(animal);
    } catch {
      case e: Exception => System.err.println("Exception" + e.toString);
    }
  }

  def getAllAnimals() = {
    val animalsList = new util.LinkedList[Animal]();
    animalsList.addAll(storage.getPackAnimals());
    animalsList.addAll(storage.getPets());
    animalsList;
  }

  def getPackAnimals() = {
    storage.getPackAnimals();
  }

  def getPets() = {
    storage.getPets();
  }

//  def getAnimalByName
}

object App extends App with AppRealization {
//  println("Model.Animals." + "Camel")
  val first = new Cat("ggg", new Date());
  val second = new Dog("gglg", new Date());
  addNewAnimal("kllm nnlk", new Date(), "Camel");
}