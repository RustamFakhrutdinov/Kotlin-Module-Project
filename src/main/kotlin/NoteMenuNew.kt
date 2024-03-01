
class NoteMenuNew (private var note: NoteNew) {
    private var isWritten: Boolean = false
    private var header: String = "Меню заметок:"
    private var input: String = "Ввести текст заметки"
    private val menu = Menu()
    fun noteMenuStart() {
        menu.menuElements.add(input)
        if (note.noteField != "") {
            menu.menuElements.add(1, "Посмотреть заметку")
            isWritten = true
        }
        menu.menuElements.add("Выход")
        do {
            val result: Int = menu.startMenu(header, screen = { element -> element.showNote() }, note )
            if(result == 0) {
                menu.enterText(note)
                if (!isWritten && note.noteField != "") {
                    menu.menuElements.add(1, "Посмотреть заметку")
                    isWritten = true
                }
            }

        } while (result != menu.menuElements.size - 1)
    }
}