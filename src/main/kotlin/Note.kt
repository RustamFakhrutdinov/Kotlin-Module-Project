class Note(val name:String) {
    var noteField: String = ""

    fun showNote() {
        println(noteField)
    }

    fun makeNote(note: String) {
        noteField += note
    }
}