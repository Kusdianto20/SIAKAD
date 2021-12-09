package com.project01.siakad1.networking

import com.example.liveattendanceapp.model.ChangePasswordResponse
import com.project01.siakad1.networking.response.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface ModulApiService {
    @Headers("Accept: application/json", "Content-Type: application/json")
    @POST("auth/login")
    fun loginRequest(
        @Body body: String)
    : Call<LoginResponse>

    @Headers("Accept: application/json", "Content-Type: application/json")
    @POST("auth/password/reset")
    fun changePassword(
        @Header("Authorization") token: String,
        @Body body: String)
    : Call<ChangePasswordResponse>
}