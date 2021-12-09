package com.project01.siakad1.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import com.example.liveattendanceapp.dialog.MyDialog
import com.example.liveattendanceapp.hawkstorage.HawkStorage
import com.google.gson.Gson
import com.project01.siakad1.MainActivity
import com.project01.siakad1.R
import com.project01.siakad1.databinding.ActivityLoginBinding
import com.project01.siakad1.networking.ApiService
import com.project01.siakad1.networking.RetrofitClient
import com.project01.siakad1.networking.response.LoginResponse
import okhttp3.ResponseBody
import org.jetbrains.anko.startActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Converter
import retrofit2.Response
import java.io.IOException

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    /*companion object {
        private val TAG = LoginActivity::class.java.simpleName
    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onClick()
    }

    private fun onClick() {
        binding.btnLogin.setOnClickListener {
            val mainActivity = Intent(this, MainActivity::class.java)
            startActivity(mainActivity)
           /* val username = binding.edtUsernameLogin.text.toString()
            val password = binding.edtPasswordLogin.text.toString()
            if (isFormValid(username, password)){
                loginToServer(username, password)
            }*/
        }

        /*binding.btnForgotPassword.setOnClickListener {
            startActivity<ForgotPasswordActivity>()
        }
        */
    }

    /*private fun loginToServer(username: String, password: String) {
        val loginRequest = LoginRequest(username = username, password = password, deviceName = "mobile")
        val loginRequestString = Gson().toJson(loginRequest)
        MyDialog.showProgressDialog(this)

        ApiService.getLiveAttendanceServices()
            .loginRequest(loginRequestString)
            .enqueue(object : Callback<LoginResponse> {
                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    MyDialog.hideDialog()
                    if (response.isSuccessful){
                        val user = response.body()?.user
                        val token = response.body()?.meta?.token
                        if (user != null && token != null){
                            HawkStorage.instance(this@LoginActivity).setUser(user)
                            HawkStorage.instance(this@LoginActivity).setToken(token)
                            goToMain()
                        }
                    }else{
                        val errorConverter: Converter<ResponseBody,
                                LoginResponse> = RetrofitClient
                                .getClient()
                                .responseBodyConverter(
                                    LoginResponse::class.java,
                                    arrayOfNulls<Annotation>(0)
                                )
                        var errorResponse: LoginResponse?
                        try {
                            response.errorBody()?.let {
                                errorResponse = errorConverter.convert(it)
                                MyDialog.dynamicDialog(
                                    this@LoginActivity,
                                    getString(R.string.failed),
                                    errorResponse?.message.toString()
                                )
                            }
                        }catch (e: IOException){
                            e.printStackTrace()
                            Log.e(TAG, "Error: ${e.message}")
                        }
                    }
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    MyDialog.hideDialog()
                    Log.e(TAG, "Error: ${t.message}")
                }

            })
    }

    private fun goToMain() {
        startActivity<MainActivity>()
        finishAffinity()
    }

    private fun isFormValid(username: String, password: String): Boolean {
        if (username.isEmpty()){
            binding.edtUsernameLogin.error = getString(R.string.please_field_your_username)
            binding.edtUsernameLogin.requestFocus()
        }else if (!Patterns.PHONE.matcher(username).matches()){
            binding.edtUsernameLogin.error = getString(R.string.please_use_valid_username)
            binding.edtUsernameLogin.requestFocus()
        }else if (password.isEmpty()){
            binding.edtUsernameLogin.error = null
            binding.edtPasswordLogin.error = getString(R.string.please_field_your_password)
            binding.edtPasswordLogin.requestFocus()
        }else{
            binding.edtUsernameLogin.error = null
            binding.edtPasswordLogin.error = null
            return true
        }
        return false
    }*/
}
