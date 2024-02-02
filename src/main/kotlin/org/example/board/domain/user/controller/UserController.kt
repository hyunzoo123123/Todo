package org.example.board.domain.user.controller

import org.springframework.web.bind.annotation.PostMapping

class UserController {
    @PostMapping
    fun signUp() {
        println("UserController.signUp")
    }

    @PostMapping
    fun signIn() {
        println("UserController.signIn")
    }
}