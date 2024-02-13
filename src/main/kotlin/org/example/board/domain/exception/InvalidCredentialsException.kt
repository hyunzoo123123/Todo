package org.example.board.domain.exception

data class InvalidCredentialsException(val target:String) : RuntimeException(
    "The credential is invalid. $target does not match."
)