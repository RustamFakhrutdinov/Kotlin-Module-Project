import java.util.Scanner

class Menu{
    var menuElements: MutableList<String> = mutableListOf()

    private fun showMenu(elementsOfMenu: MutableList<String>, header: String) {
        println(header)
        for(i in elementsOfMenu) {
            println(elementsOfMenu.indexOf(i).toString() + ". " + i)
        }
    }

    private fun readUserInput():Int? {
        val userInput: Int? = Scanner(System.`in`).nextLine().toIntOrNull()
        if (userInput == null) {
            println("Введен не номер. Пожалуйста введите номер пункта меню")
        }
        return userInput
    }

    fun getName(input: String, error: String): String {
        var userInput: String = ""
        while (userInput == "") {
            println(input)
            userInput = Scanner(System.`in`).nextLine()
            if (userInput == "") {
                println(error)
            }
        }
        return userInput
    }
    fun <T: Element>createElement(element: T, list: MutableList<T>) {
            list.add(element)
            menuElements.add(menuElements.size - 1,list.last().name)
    }
    fun enterText(note: NoteNew){
        val text: String = Scanner(System.`in`).nextLine()
        if(text == "") {
            println("Нельзя оставить заметку пустой")
        } else {
            note.makeNote(text)
        }
    }
    fun <T: Element>startMenu(header: String,  screen: (T) -> Unit, listForSaving: MutableList<T>): Int {

        var userInput: Int?
        while(true) {
            this.showMenu(menuElements, header)
            userInput = this.readUserInput()
            if (userInput != null) {
                when  {
                    userInput == menuElements.size - 1 -> return userInput //выход
                    userInput == 0 -> { // создание элемента
                        return userInput
                    }
                    (userInput > menuElements.size - 1) || (userInput < 0) -> println("Такого пункта нет. Пожалуйста, введите корректный номер меню")
                    else -> break //выходим из этого меню, чтобы перейти в меню заметок
                }
            }
        }
        if(userInput != menuElements.size - 1) {
            screen(listForSaving[userInput!! - 1])
        }
        return userInput
    }

    fun startMenu(header: String,  screen: (NoteNew) -> Unit, note: NoteNew): Int {//перегружаю функцию для экрана заметки

        var userInput: Int?
        while(true) {
            this.showMenu(menuElements, header)
            userInput = this.readUserInput()
            if (userInput != null) {
                when  {
                    userInput == menuElements.size - 1 -> return userInput //выход
                    userInput == 0 -> { // создание элемента
                        return userInput
                    }
                    (userInput > menuElements.size - 1) || (userInput < 0) -> println("Такого пункта нет. Пожалуйста, введите корректный номер меню")
                    else -> break //выходим из этого меню, чтобы перейти в меню заметок
                }
            }
        }
        if(userInput != menuElements.size - 1) {
            screen(note)
        }
        return userInput!!
    }

}