package com.example.notes.data.remote

import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val api: ApiService,
    private val token: String // Bearer Token
) {
    suspend fun fetchNotes(): List<NetworkNote> {
        return api.getNotes()
            .takeIf { it.isSuccessful }
            ?.body() ?: emptyList()
    }

    suspend fun deleteNote(id: String) {
        api.deleteNote(id)
    }
}
