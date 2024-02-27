class NotesScreen(var archive: Archive) {
    var header: String = "Список заметок:"
    var isNote: Boolean = false
    var elementsOfMenu: MutableList<String> = mutableListOf()
    val menu = MenuLogic()
    fun startNoteMenu() {

        elementsOfMenu.add("Создать заметку")
        if (archive.listOfNotes != null) {
            for (i in archive.listOfNotes) {
                elementsOfMenu.add( i.name)
            }
            isNote = true
        }
        elementsOfMenu.add("Выход")
        var userInput: Int? = null

        do {

            while(true) {
                println(header)
                menu.showMenu(elementsOfMenu)
                userInput = menu.readUserInput()
                if (userInput != null) {
                    when  {
                        userInput == elementsOfMenu.size - 1 -> break //выход
                        userInput == 0 -> { // создание заметки
                            archive.listOfNotes.add(menu.createNote())
                            elementsOfMenu.add(elementsOfMenu.size - 1, archive.listOfNotes.last().name)
                        }
                        (userInput > elementsOfMenu.size - 1) || (userInput < 0) -> println("Такого пункта нет. Пожалуйста, введите корректный номер меню")
                        else -> break //выходим из этого меню, чтобы перейти в заметку
                    }
                }
            }
            if(userInput != elementsOfMenu.size - 1) {
                NoteMenu(archive.listOfNotes[userInput!! - 1]).noteMenuStart()
            }



        } while(userInput !=  elementsOfMenu.size - 1)
    }
}