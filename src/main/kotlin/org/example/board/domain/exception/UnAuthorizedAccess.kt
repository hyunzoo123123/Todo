package org.example.board.domain.exception

class UnAuthorizedAccess(
    override val message: String
): RuntimeException(message) {
}