package org.example.board.domain.comment.controller

import org.example.board.domain.comment.dto.CommentCreateRequest
import org.example.board.domain.comment.dto.CommentResponse
import org.example.board.domain.comment.dto.CommentUpdateRequest
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
    fun readComment(
        @PathVariable postId: Long,
        @PathVariable commentsId: Long
    ) : ResponseEntity<CommentResponse> {
          return ResponseEntity
                .status(HttpStatus.OK)
                .body(commentService.readComment(postId, commentsId))
    }

    @PutMapping("/{postId}/comments/{commentsId}")
    fun updateComment(
        @PathVariable postId: Long,
        @RequestBody commentUpdateRequest: CommentUpdateRequest
    ) : ResponseEntity<CommentResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(commentService.updateComment(postId, commentUpdateRequest))
    }

    @DeleteMapping("/{postId}/comments/{commentId}")
    fun deleteComment(

        @PathVariable postId: Int,        // 포스트 ID를 경로 변수로 받음
        @PathVariable commentId: Int      // 댓글 ID를 경로 변수로 받음
    ): ResponseEntity<Unit> {
        return ResponseEntity
            .status(HttpStatus.NO_CONTENT)
            .body(commentService.deleteComment(postId, commentId))
    }
}