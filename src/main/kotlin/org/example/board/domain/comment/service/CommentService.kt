package org.example.board.domain.comment.service

import org.example.board.domain.comment.dto.CommentCreateRequest
import org.example.board.domain.comment.dto.CommentResponse

interface CommentService {
    fun createComment(postId : Long, request: CommentCreateRequest): CommentResponse
    fun updateComment(postId: Long, content: String)
    fun deleteComment(postId: Long, commentId: Long)
    fun readComment(postId: Long, commentId: Long)

}