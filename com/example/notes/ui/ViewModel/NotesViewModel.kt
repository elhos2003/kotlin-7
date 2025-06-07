class NotesViewModel @Inject constructor(
    private val repo: NotesRepository
) : ViewModel() {
    private val _notes = MutableStateFlow<List<Note>>(emptyList())
    val notes: StateFlow<List<Note>> = _notes

    init {
        loadNotes()
    }

    private fun loadNotes() {
        viewModelScope.launch {
            repo.getNotes().collect { _notes.value = it }
        }
    }

    fun deleteNote(id: String) {
        viewModelScope.launch {
            repo.deleteNote(id)
        }
    }
}
