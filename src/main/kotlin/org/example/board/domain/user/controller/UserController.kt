package org.example.board.domain.user.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController {
    @PostMapping("/sign-up")
    fun signUp() {
        println("UserController.signUp")
    }

    @PostMapping("/sign-in")
    fun signIn() {
        println("UserController.signIn")
    }
}