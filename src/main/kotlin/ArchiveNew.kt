class ArchiveNew(private var archiveName: String): Element(name = archiveName) {
    var listOfNotes: MutableList<NoteNew> = mutableListOf()
}