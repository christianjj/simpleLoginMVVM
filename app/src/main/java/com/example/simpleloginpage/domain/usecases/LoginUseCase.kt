package com.example.simpleloginpage.domain.usecases

import com.example.simpleloginpage.core.Resource
import com.example.simpleloginpage.data.model.LoginRequest
import com.example.simpleloginpage.domain.model.LoginDomainModel
import com.example.simpleloginpage.domain.repository.LoginRepository

import kotlinx.coroutines.flow.Flow

class LoginUseCase(
    private val loginRepository: LoginRepository
) {
    operator fun invoke(loginRequest: LoginRequest): Flow<Resource<LoginDomainModel>> {
        return loginRepository.login(loginRequest)
    }
}