sealed interface Command {
    fun isValid(): Boolean


    class AddPhone(val name: String, val phone: String) : Command {
        override fun isValid(): Boolean {
            val regex = """^\+[0-9]{10,11}$""".toRegex()
            return phone.matches(regex)
        }

        override fun toString(): String {
            return "name = $name, phone = $phone"
        }
    }


    class AddEmail(val name: String, val email: String) : Command {
        override fun isValid(): Boolean {
            return email.matches(Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\$"))
        }

        override fun toString(): String {
            return "name = $name, email = $email"
        }
    }


    class Show(val person: Person?) : Command {
        override fun isValid(): Boolean {
            return true
        }

        override fun toString(): String {
            return "Последняя выполненная команда:"
        }
    }


    class Help() : Command {
        override fun isValid(): Boolean {
            return true
        }

        fun printhelp() {
            println(
                "add <Имя> <Номер телефона> - добавление имени и номера телефона в форомате +XXXXXXXXXXX\n" +
                "add <Имя> <Адрес электронной почты> добавление имени и дреса электронной почты\n" +
                "help - описание команд\n" +
                "show - показать выполеннную команду\n"+
                "exit - завершение программы\n"
            )
        }
        override fun toString(): String {
            return "Описание команд:"
        }
    }
}