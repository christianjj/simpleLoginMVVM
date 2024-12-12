package com.example.simpleloginpage.domain.repository

import com.example.simpleloginpage.core.Resource
import com.example.simpleloginpage.domain.model.LoginDomainModel
import kotlinx.coroutines.flow.Flow

interface LoginRepository {
    fun login(username: String, password: String): Flow<Resource<LoginDomainModel>>
}
