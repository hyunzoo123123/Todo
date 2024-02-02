package org.example.board.domain.comment.controller

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping

class CommentController {
    @PostMapping
    fun createComment() {
        println("PostController.create")
    }

    @GetMapping
    fun readComment() {
        println("PostController.read")
    }

    @PutMapping
    fun updateComment() {
        println("PostController.update")
    }

    @DeleteMapping
    fun deleteComment() {
        println("PostController.delete")
    }
}