import java.io.File

data class Person(
    var name: String,
    var phone: MutableList<String> = mutableListOf(),
    var email: MutableList<String> = mutableListOf()
) {

    fun addPhone (name: String, phone: String) {
        val existingPerson = phoneBook[name]
        if (existingPerson != null) {
            existingPerson.phone.add(phone)
        } else {
            val newPerson = Person(name)
            newPerson.phone.add(phone)
            addPerson(newPerson)
        }
    }

    fun addEmail(name: String, email: String) {
        val existingPerson = phoneBook[name]
        if (existingPerson != null) {
            existingPerson.email.add(email)
        } else {
            val newPerson = Person(name)
            newPerson.email.add(email)
            //phoneBook[name] = newPerson
            addPerson(newPerson)
        }
    }

    fun show() {
        println("Имя: $name")
        println("Телефоны: ${phone.joinToString(", ")}")
        println("Emails: ${email.joinToString(", ")}")
    }


    companion object {
        private val phoneBook: MutableMap<String, Person> = mutableMapOf()

        fun addPerson(person: Person) {
            phoneBook[person.name] = person
        }

        fun find(value: String) {
            val matchingPeople = phoneBook.values.filter { person ->
                person.phone.contains(value) || person.email.contains(value)
            }
            if (matchingPeople.isNotEmpty()) {
                println("Люди с телефоном или email '$value':")
                matchingPeople.forEach { it.show() }
            } else {
                println("Нет записей для телефона или email '$value'")
            }
        }


        fun showContacts(value: String) {
            val matchingPeople = phoneBook.values.filter { person ->
                person.name.contains(value)
            }
            if (matchingPeople.isNotEmpty()) {
                println("Контакты с именем '$value':")
                matchingPeople.forEach { it.show() }
            } else {
                println("Нет записей для '$value'")
            }
        }

        fun export(fileData: String) {
            val jsonObjects = phoneBook.values.map { person ->
                json {
                    appendData("имя", person.name)
                    appendData("телефон", person.phone)
                    appendData("email", person.email)
                }
            }

            val jsonFormat = "[${jsonObjects.joinToString(", ")}]"
            File(fileData).writeText(jsonFormat)
            println("Данные записаны в файл: $fileData")
        }
    }
}
