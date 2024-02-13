package org.example.board.domain.post.controller

import jakarta.validation.Valid
import org.example.board.domain.post.dto.PostCreateRequest
import org.example.board.domain.post.dto.PostResponse
import org.example.board.domain.post.dto.PostUpdateRequest
import org.example.board.domain.post.service.PostService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/posts")

class PostController(
    private var postService: PostService
) {

    @GetMapping()
    fun getPostList(
        @PathVariable postId: Long
    ): ResponseEntity<List<PostResponse>> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(postService.getPostList())
    }

    @GetMapping("/{postId}")
    fun getPost(
        @PathVariable postId: Long
    ): ResponseEntity<PostResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(postService.getPost(postId))
    }

    @PostMapping()
    fun createPost(
        @PathVariable postId: Long,
       @RequestBody request: PostCreateRequest
    ): ResponseEntity<PostResponse> {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(postService.createPost(request))
    }

    @PutMapping("/{postId}/update")
    fun updatePost(
        @PathVariable postId: Long,
        @Valid @RequestBody request: PostUpdateRequest
    ): ResponseEntity<PostResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(postService.updatePost(postId, request))
    }

    @DeleteMapping("/{postId}/delete")
    fun deletePost(
        @PathVariable postId: Long,
    ) : ResponseEntity<Unit> {
        return ResponseEntity
            .status(HttpStatus.NO_CONTENT)
            .body(postService.deletePost(postId))
    }
}