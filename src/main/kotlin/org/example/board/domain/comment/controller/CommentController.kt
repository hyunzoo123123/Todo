package org.example.board.domain.comment.controller

import org.springframework.web.bind.annotation.PostMapping

class CommentController {
    @PostMapping
    fun create() {
        println("CommentController.create")
    }
}