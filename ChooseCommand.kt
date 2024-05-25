import Person.Companion.find
import Person.Companion.showContacts

class ChooseCommand {
    fun chooseCommand() {
        var person: Person? = null
        val commandSorter = ExecutingСommands()

        while (true) {
            println()
            println(
                "Введите команду как показано ниже:\n" +
                        "add <Имя> <Номер телефона>\n" +
                        "add <Имя> <Адрес электронной почты>\n" +
                        "show\n" +
                        "find\n" +
                        "help\n" +
                        "exit"
            )

            val command = commandSorter.readCommand()

            println(command)

            when (command) {
                is Command.AddPhone -> {
                    person = Person(command.name)
                    person.addPhone(command.name, command.phone)
                }

                is Command.AddEmail -> {
                    person = Person(command.name)
                    person.addEmail(command.name, command.email)
                }

                is Command.Help -> {
                    command.printhelp()
                }

                is Command.Find ->{
                    while(true){
                        println("Введите <Номер телефона> или <Адрес электронной почты> для поиска\n или exit чтобы выйти")
                        val data = readln()
                        if (data == "exit"){
                            chooseCommand()
                        } else find(data)
                    }
                }

                is Command.Show -> {
                    while(true){
                        println("Введите <Имя> для поиска\n или exit чтобы выйти")
                        val data = readln()
                        if (data == "exit"){
                            chooseCommand()
                        } else showContacts(data)
                    }
                }
            }
        }
    }
}