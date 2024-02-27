class ArchivesScreen {
    var header: String = "Список архивов:"
    var archiveElements: MutableList<Archive> = mutableListOf()
    var elementsOfMenu: MutableList<String> = mutableListOf()
    val menu = MenuLogic()
    fun startArchiveMenu() {
        elementsOfMenu.add("Создать архив")
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
                        userInput == 0 -> { // создание архива
                            archiveElements.add(menu.createArchive())
                            elementsOfMenu.add(elementsOfMenu.size - 1,archiveElements.last().name)
                        }
                        (userInput > elementsOfMenu.size - 1) || (userInput < 0) -> println("Такого пункта нет. Пожалуйста, введите корректный номер меню")
                        else -> break //выходим из этого меню, чтобы перейти в меню заметок
                    }
                }
            }
            if(userInput != elementsOfMenu.size - 1) {
                NotesScreen(archiveElements[userInput!! - 1]).startNoteMenu()
            }



        } while(userInput !=  elementsOfMenu.size - 1)
    }
}