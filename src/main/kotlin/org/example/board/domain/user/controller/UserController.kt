package org.example.board.domain.user.controller

import org.springframework.web.bind.annotation.PostMapping

class UserController {
    @PostMapping
    fun sIgnUp() {
        println("UserController.sIgnUp")
    }
}