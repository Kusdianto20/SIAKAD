package com.project01.siakad1.networking

object ApiService {
    fun getLiveAttendanceServices(): ModulApiService {
        return RetrofitClient
            .getClient()
            .create(ModulApiService::class.java)
    }
}