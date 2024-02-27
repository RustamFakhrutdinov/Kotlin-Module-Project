import java.util.Scanner

class NoteMenu(var note: Note) {
    var elementsOfMenu: MutableList<String> = mutableListOf()
    val menu = MenuLogic()
    var isWritten: Boolean = false
    fun noteMenuStart() {
        elementsOfMenu.add("Ввести текст заметки")
        if (note.noteField != "") {
            elementsOfMenu.add(1, "Посмотреть заметку")
            isWritten = true
        }
        elementsOfMenu.add("Выход")
        var userInput: Int? = null

        do {

            while(true) {
                menu.showMenu(elementsOfMenu)
                userInput = menu.readUserInput()
                if (userInput != null) {
                    when  {
                        userInput == elementsOfMenu.size - 1 -> break //выход
                        userInput == 0 -> { // ввести текст заметки
                            val text: String = Scanner(System.`in`).nextLine()
                            if(text == "") {
                                println("Нельзя оставить заметку пустой")
                                break
                            } else {
                                note.makeNote(text)
                                if (!isWritten) {
                                    elementsOfMenu.add(1, "Посмотреть заметку")
                                    isWritten = true
                                }

                            }
                        }
                        (userInput > elementsOfMenu.size - 1) || (userInput < 0) -> println("Такого пункта нет. Пожалуйста, введите корректный номер меню")
                        else -> break //выходим из этого меню, чтобы перейти в заметку
                    }
                }
            }
            if(userInput != elementsOfMenu.size - 1) {
                note.showNote()
            }



        } while(userInput !=  elementsOfMenu.size - 1)
    }
}