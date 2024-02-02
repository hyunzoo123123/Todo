package org.example.board.domain.user.dto

data class UserLoginRequest (
    val email: String,
    val password: String
)