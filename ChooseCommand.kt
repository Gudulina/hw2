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
                        "help\n" +
                        "exit"
            )

            val command = commandSorter.readCommand()

            println(command)

            when (command) {
                is Command.AddPhone -> {
                    person = Person(command.name)
                    person.phone = command.phone
                }

                is Command.AddEmail -> {
                    person = Person(command.name)
                    person.email = command.email
                }

                is Command.Help -> {
                    command.printhelp()
                }

                is Command.Show -> {
                    if (person == null) {
                        println("Null")
                    } else {
                        if (person.phone.isNotEmpty()) {
                            println("Имя: ${person.name}, Phone: ${person.phone}")
                            println()
                        }
                        if (person.email.isNotEmpty()) {
                            println("Имя: ${person.name}, Email: ${person.email}")
                            println()
                        }
                    }
                }
            }
        }
    }
}