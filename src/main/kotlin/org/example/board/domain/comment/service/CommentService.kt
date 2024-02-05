package org.example.board.domain.comment.service

interface CommentService {
    fun createComment(postId : Long, content : String)
    fun updateComment(postId: Long, content: String)
    fun deleteComment(postId: Long, commentId: Long)
    fun readComment(postId: Long, commentId: Long)

}