package org.example.board.domain.post.controller

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/posts")
class PostController {
    @PostMapping
    fun createPost() {
        println("PostController.create")
    }

    @GetMapping("/{postId}")
    fun readPost() {
        println("PostController.read")
    }

    @PutMapping("/{postId}")
    fun updatePost() {
        println("PostController.update")
    }

    @DeleteMapping("/{postId}")
    fun deletePost() {
        println("PostController.delete")
    }
}