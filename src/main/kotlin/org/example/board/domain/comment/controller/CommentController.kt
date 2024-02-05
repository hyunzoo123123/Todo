package org.example.board.domain.comment.controller

import org.example.board.domain.comment.dto.CommentCreateRequest
import org.example.board.domain.comment.dto.CommentResponse
import org.example.board.domain.comment.service.CommentService
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/posts")
class CommentController(
    private val commentService: CommentService
){
    @PostMapping("/{postId}/comments/{commentsId}")
    fun createComment(
        @PathVariable postId: Long,
        @RequestBody commentCreateRequest: CommentCreateRequest
    ):ResponseEntity<CommentResponse> {
      return ResponseEntity
          .status(HttpStatus.CREATED)
          .body(commentService.createComment(postId,commentCreateRequest))
    }

    @GetMapping("/{postId}/comments")
    fun readComment() {
        println("PostController.read")
    }

    @PutMapping("/{postId}/comments/{commentsId}")
    fun updateComment() {
        println("PostController.update")
    }

    @DeleteMapping("/{postId}/comments/{commentsId}")
    fun deleteComment() {
        println("PostController.delete")
    }
}