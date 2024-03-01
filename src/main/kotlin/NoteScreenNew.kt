class NoteScreenNew(var archive: ArchiveNew) {
        var header: String = "Список заметок:"
        var creation: String = "Создать заметку"
        var input: String = "Введите имя заметки"
        var error: String = "Нельзя создать заметку без названия"
        val menu = Menu()
        fun startNoteMenu() {
                menu.menuElements.add(creation)
                for (i in archive.listOfNotes) {
                        menu.menuElements.add( i.name)
                }
                menu.menuElements.add("Выход")
                do {
                        val result: Int = menu.startMenu(header, screen = { element -> NoteMenuNew(element).noteMenuStart() }, archive.listOfNotes )
                        if(result == 0) {
                                menu.createElement(NoteNew(menu.getName(input,error)), archive.listOfNotes)
                        }
                } while (result != menu.menuElements.size - 1)
        }
}