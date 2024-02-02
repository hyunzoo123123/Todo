package org.example.board.domain.post.controller

import org.springframework.web.bind.annotation.PostMapping

class PostController {
    @PostMapping
    fun create() {
        println("PostController.create")
    }
}