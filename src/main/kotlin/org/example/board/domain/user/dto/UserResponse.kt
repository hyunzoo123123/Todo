package org.example.board.domain.user.dto

import java.time.LocalDateTime

data class UserResponse(
    val id: Long,
    val email: String,
    val password: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime?,

)
