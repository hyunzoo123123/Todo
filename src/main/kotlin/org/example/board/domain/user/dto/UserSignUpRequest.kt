package org.example.board.domain.user.dto

data class UserSignUpRequest (
    val email: String,
    val password: String
)