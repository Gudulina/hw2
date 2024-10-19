import kotlin.system.exitProcess

class ExecutingСommands {
    fun readCommand(): Command {
        val inputData = readlnOrNull() ?: ""
        val parts = inputData.split(" ")

        return when {
            inputData.startsWith("add") && parts.size == 3 -> {
                if (Command.AddPhone(parts[1], parts[2]).isValid()) {
                    Command.AddPhone(parts[1], parts[2])
                } else {
                    println("Неверный формат номера телефона!")
                    println()
                    Command.Help()
                }
            }

            inputData.startsWith("add") && parts.size == 4 -> {
                if (Command.AddEmail(parts[1], parts[3]).isValid()) {
                    Command.AddEmail(parts[1], parts[3])
                } else {
                    println("Неверный адрес электронной почты!")
                    println()
                    Command.Help()
                }
            }

            inputData == "help" -> Command.Help()
            inputData == "find" -> Command.Find()
            inputData == "show" -> Command.Show()
            inputData == "export" -> Command.Export()
            inputData == "exit" -> exitProcess(0)

            else -> {
                println("Ошибка! Команда не распознана!")
                Command.Help()
            }
        }
    }
}