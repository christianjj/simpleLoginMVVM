package com.example.simpleloginpage.data.datasource



import com.example.simpleloginpage.core.Resource
import com.example.simpleloginpage.data.model.LoginRequest
import com.example.simpleloginpage.domain.model.LoginDomainModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LoginDataSource {
    fun login(loginRequest: LoginRequest): Flow<Resource<LoginDomainModel>> = flow {
        emit(Resource.Loading)
        delay(1500)
        if (loginRequest.username == "user" && loginRequest.password == "password") {
            val loginResult = LoginDomainModel(
                username = loginRequest.username,
                isLoggedIn = true
            )
            emit(Resource.Success(loginResult))
        } else {
            emit(Resource.Error("Invalid credentials"))
        }
    }
}