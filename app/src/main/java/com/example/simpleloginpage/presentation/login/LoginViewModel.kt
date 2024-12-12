package com.example.simpleloginpage.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simpleloginpage.core.Resource
import com.example.simpleloginpage.domain.usecases.LoginUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(
    private val loginUseCase: LoginUseCase
) : ViewModel() {
    private val _loginState = MutableStateFlow(LoginState())
    val loginState: StateFlow<LoginState> = _loginState.asStateFlow()

    fun login(username: String, password: String) {
        viewModelScope.launch {
            loginUseCase(username, password)
                .collect { resource ->
                    when (resource) {
                        is Resource.Loading -> {
                            _loginState.update {
                                it.copy(
                                    isLoading = true,
                                    errorMessage = null
                                )
                            }
                        }
                        is Resource.Success -> {
                            _loginState.update {
                                it.copy(
                                    isLoading = false,
                                    isLoggedIn = true,
                                    errorMessage = null
                                )
                            }
                        }
                        is Resource.Error -> {
                            _loginState.update {
                                it.copy(
                                    isLoading = false,
                                    isLoggedIn = false,
                                    errorMessage = resource.message
                                )
                            }
                        }
                    }
                }
        }
    }
}
