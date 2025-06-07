package com.example.notes.data.remote

import com.example.notes.data.remote.NetworkNote
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @GET("notes")
    suspend fun getNotes(): Response<List<NetworkNote>>

    @POST("notes")
    suspend fun addNote(@Body note: NetworkNote): Response<Unit>

    @DELETE("notes/{id}")
    suspend fun deleteNote(@Path("id") id: String): Response<Unit>
}
