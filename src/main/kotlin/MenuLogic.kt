import java.util.Scanner



class MenuLogic {
    fun showMenu(menuElements: MutableList<String>) {
        for(i in menuElements) {
            println(menuElements.indexOf(i).toString() + ". " + i)
        }
    }

    fun readUserInput():Int? {
        val userInput: Int? = Scanner(System.`in`).nextLine().toIntOrNull()
        if (userInput == null) {
            println("Введен не номер. Пожалуйста введите номер пункта меню")
        }
        return userInput
    }

    fun createArchive(): Archive {
        var userInput: String = ""
        while (userInput == "") {
            println("Введите название архива")
            userInput = Scanner(System.`in`).nextLine()
            if (userInput == "") {
                println("Нельзя создать архив без названия")
            }
        }
        return Archive(userInput)
    }

    fun createNote(): Note {
        var userInput: String = ""
        while (userInput == "") {
            println("Введите название заметки")
            userInput = Scanner(System.`in`).nextLine()
            if (userInput == "") {
                println("Нельзя создать заметку без названия")
            }
        }
        return Note(userInput)
    }

}