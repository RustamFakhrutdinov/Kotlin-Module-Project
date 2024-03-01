class ArchiveScreenNew {
    private var header: String = "Список архивов:"
    private var creation: String = "Создать архив"
    private var input: String = "Введите имя архива"
    private var error: String = "Нельзя создать архив без названия"
    private val menu = Menu()
    fun startArchiveMenu() {
        val list:  MutableList<ArchiveNew> = mutableListOf()
        menu.menuElements.add(creation)
        menu.menuElements.add("Выход")
        do {
            val result: Int = menu.startMenu(header, screen = { element -> NoteScreenNew(element).startNoteMenu() }, list )
            if(result == 0) {
                menu.createElement(ArchiveNew(menu.getName(input,error)), list)
            }
        } while (result != menu.menuElements.size - 1)

    }



}