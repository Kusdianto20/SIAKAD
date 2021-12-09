package com.project01.siakad1.ui.login

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @field:SerializedName("password")
    val password: String? = null,

    @field:SerializedName("device_name")
    val deviceName: String? = null,

    @field:SerializedName("username")
    val username: String? = null
)