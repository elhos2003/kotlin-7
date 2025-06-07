package com.example.notes.data.repository

import com.example.notes.data.local.LocalDataSource
import com.example.notes.data.remote.RemoteDataSource
import kotlinx.coroutines.flow.Flow

class NotesRepository(
    private val local: LocalDataSource,
    private val remote: RemoteDataSource
) {
    fun getNotes(): Flow<List<Note>> {
        // دمج البيانات المحلية والبعيدة
    }

    suspend fun deleteNote(id: String) {
        local.deleteNote(id)
        remote.deleteNote(id)
    }
}
