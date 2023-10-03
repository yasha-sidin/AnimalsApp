package Controller

import Model.{Animal, Command}

import java.text.{ParseException, SimpleDateFormat}
import java.util.Date
import scala.io.StdIn.readLine

object AnimalsApp extends AppRealization with AutoCloseable {
  private def initApp(): Unit = {

    def addAnimalMenu(): Unit = {
      print("---------Add animal----------\n" +
        "--------Animal types--------\n" +
        "CAT\n" +
        "DOG\n" +
        "HAMSTER\n" +
        "CAMEL\n" +
        "DONKEY\n" +
        "HORSE\n" +
        "---------------------------\n" +
        "--------Date format--------\n" +
        "dd.mm.yyyy\n" +
        "---------------------------\n");
      val name = readLine("Input animal's name: ");
      val stringDate = readLine("Input date of animal's birth: ");
      val animalType = readLine("Input animal's type: ");
      val formatter = new SimpleDateFormat("dd.MM.yyyy");
      try {
        val dateOfBirth: Date = formatter.parse(stringDate);
        addNewAnimal(name, dateOfBirth, animalType);
        println("Animal was added as successfully! ");
        initApp();
      } catch {
        case e: ParseException => println("Not a valid format of Birth date.");
        case e: Exception => println(s"Exception: $e");
      } finally {
        initApp();
      }
    }

    def animalMenu(animal: Animal = null): Unit = {
      var animalCurrent = animal;

      def executeCommand(animal: Animal): Unit = {
        val commandName = readLine("Enter the command's name: ");
        val command = getCommandByName(animal, commandName);
        command match {
          case null => {
            println("This animal doesn't have command with this name. Choose other command.");
            animalMenu(animal);
          };
          case _ => {
            command.execute;
            animalMenu(animal);
          };
        }
      }

      def addCommand(animal: Animal): Unit = {
        val commandName = readLine("Enter the command's name: ");
        val realization = readLine("Enter the string realization of the command: ");
        try {
          animal.addCommand(new Command(commandName, realization));
          println("Command was added as successfully! ");
          animalMenu(animal);
        } catch {
          case e: Exception => println(s"Exception: $e");
        } finally {
          animalMenu(animal);
        }
      }

      if (animalCurrent == null) {
        val animalName = readLine("Enter animal's name from the list: ")
        animalCurrent = getAnimalByName(animalName);
      }

      animalCurrent match {
        case null => {
          println("There isn't animal with this name in the list. Please choose the correct name. ");
          initApp();
        }
        case _ => {
          val formatter = new SimpleDateFormat("dd.MM.yyyy");
          print(
            s"""----------Animal----------
          Name: ${animalCurrent.getName}
          Type: ${animalCurrent.getClass.getName.split('.')(animalCurrent.getClass.getName.split('.').length - 1)}
          DateOfBirth: ${formatter.format(animalCurrent.getDateOfBirth)}
          Commands:
          ${stringCommands(animalCurrent)}
          Animal's menu params:
          1 - Execute command by its name
          2 - Teach the animal new command
          3 - Exit from animal's menu
      """);
          val command = readLine("Enter the command: ");
          command match {
            case "1" => executeCommand(animalCurrent);
            case "2" => addCommand(animalCurrent);
            case "3" => initApp();
            case _ => {
              println("Please enter correct command.");
              animalMenu(animal);
            };
          }
        }
      }
    }

    print("----------------App menu------------------\n" +
      s"Animals amount: $getCounterNum\n" +
      "-----Pack animals-----\n" +
      s"$stringPackAnimals" +
      "----------------------\n" +
      "---------Pets---------\n" +
      s"$stringPets" +
      "----------------------\n" +
      "------Activities------\n" +
      "1 - Add new animal\n" +
      "2 - Choose animal by name\n" +
      "Exit - close App\n" +
      "-------------------End-------------------\n");
    val command = readLine("Enter command: ")
    command match {
      case "1" => addAnimalMenu();
      case "2" => animalMenu();
      case "Exit" => close();
      case _ => println("Please enter correct command.");
    }
  }

  def start(): Unit = {
      initApp()
  }

  override def close(): Unit = {
    println("App was closed. Goodbye! ");
    System.exit(0);
  }
}