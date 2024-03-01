class NoteNew (private val noteName:String): Element(name = noteName) {
    var noteField: String = ""

    fun showNote() {
        println(noteField)
    }

    fun makeNote(note: String) {
        noteField += note
    }
}