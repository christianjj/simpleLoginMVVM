package com.example.simpleloginpage.domain.repository

import com.example.simpleloginpage.core.Resource
import com.example.simpleloginpage.data.model.LoginRequest
import com.example.simpleloginpage.domain.model.LoginDomainModel
import kotlinx.coroutines.flow.Flow

interface LoginRepository {
    fun login(loginRequest: LoginRequest): Flow<Resource<LoginDomainModel>>
}
