package com.example.simpleloginpage.presentation.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.lifecycleScope
import com.example.simpleloginpage.databinding.ActivityLoginBinding
import com.example.simpleloginpage.presentation.welcome.WelcomeActivity
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val loginViewModel: LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onClickListener()
        setupSubscribe()

    }

    private fun onClickListener(){
        binding.apply {
            buttonLogin.setOnClickListener {
                loginViewModel.login(edittextUsername.text.toString(), edittextPassword.text.toString())
            }
        }
    }

    private fun setupSubscribe(){
        lifecycleScope.launch {
            loginViewModel.loginState.collect { state ->
                binding.apply {
                    buttonLogin.isEnabled = !state.isLoading
                    progressBar.visibility =
                        if (state.isLoading) View.VISIBLE else View.GONE
                    state.errorMessage?.let {
                        Toast.makeText(this@LoginActivity, it, Toast.LENGTH_SHORT).show()
                    }
                    if (state.isLoggedIn) {
                        val intent = Intent(this@LoginActivity, WelcomeActivity::class.java)
                        intent.putExtra("USERNAME", state.username)
                        startActivity(intent)
                        finish()
                    }
                }
            }
        }
    }
}