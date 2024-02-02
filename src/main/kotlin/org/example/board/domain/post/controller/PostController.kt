package org.example.board.domain.post.controller

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping

class PostController {
    @PostMapping
    fun createPost() {
        println("PostController.create")
    }

    @GetMapping
    fun readPost() {
        println("PostController.read")
    }

    @PutMapping
    fun updatePost() {
        println("PostController.update")
    }

    @DeleteMapping
    fun deletePost() {
        println("PostController.delete")
    }
}