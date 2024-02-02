package org.example.board.domain.user.dto

data class UserLoginResponse (
    val id: Long,
    val email: String,
    val password: String
)