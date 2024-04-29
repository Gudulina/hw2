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
                    Command.Help()
                }
            }

            inputData.startsWith("add") && parts.size == 3 -> {
                if (Command.AddEmail(parts[1], parts[2]).isValid()) {
                    Command.AddEmail(parts[1], parts[2])
                } else {
                    Command.Help()
                }
            }

            inputData == "help" -> Command.Help()
            inputData == "show" -> Command.Show(null)
            inputData == "exit" -> exitProcess(0)

            else -> {
                println("Ошибка! Команда не распознана!")
                Command.Help()
            }
        }
    }
}