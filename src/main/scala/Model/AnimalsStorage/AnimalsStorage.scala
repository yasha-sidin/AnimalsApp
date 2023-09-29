package Model.AnimalsStorage

import Model.{Animal, PackAnimal, Pet}

import java.util
class AnimalsStorage {
  private val petStorage = new util.LinkedList[Animal];
  private val packAnimalStorage = new util.LinkedList[Animal];

  def addAnimal[T <: Animal](animal: T): Unit = animal match {
    case _: Pet => petStorage.addLast(animal);
    case _: PackAnimal => packAnimalStorage.addLast(animal);
  }

  def getPets(): util.LinkedList[Animal] = {
    petStorage;
  }

  def getPackAnimals(): util.LinkedList[Animal] = {
    packAnimalStorage;
  }
}


