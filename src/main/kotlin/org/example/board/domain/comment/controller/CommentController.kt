package org.example.board.domain.comment.controller

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/posts/{postId}/comments")
class CommentController {
    @PostMapping("/{commentsId}")
    fun createComment() {
        println("PostController.create")
    }

    @GetMapping
    fun readComment() {
        println("PostController.read")
    }

    @PutMapping("/{commentsId}")
    fun updateComment() {
        println("PostController.update")
    }

    @DeleteMapping("/{commentsId}")
    fun deleteComment() {
        println("PostController.delete")
    }
}