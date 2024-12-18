package com.example.simpleloginpage.data.repository

import com.example.simpleloginpage.core.Resource
import com.example.simpleloginpage.data.datasource.LoginDataSource
import com.example.simpleloginpage.data.model.LoginRequest
import com.example.simpleloginpage.domain.model.LoginDomainModel
import com.example.simpleloginpage.domain.repository.LoginRepository

import kotlinx.coroutines.flow.Flow

class LoginRepositoryImpl(
    private val loginDataSource: LoginDataSource
) : LoginRepository {
    override fun login(loginRequest: LoginRequest): Flow<Resource<LoginDomainModel>> {
        return loginDataSource.login(loginRequest)
    }
}
