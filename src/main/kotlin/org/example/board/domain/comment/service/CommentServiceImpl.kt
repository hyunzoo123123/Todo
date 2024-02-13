package org.example.board.domain.comment.service

import org.example.board.domain.comment.dto.CommentCreateRequest
import org.example.board.domain.comment.dto.CommentResponse
import org.example.board.domain.comment.model.CommentEntity
import org.example.board.domain.exception.ModelNotFoundException
import org.example.board.domain.post.repository.PostRepository
import org.example.board.domain.user.repository.UserRepository
import org.springdoc.core.service.SecurityService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CommentServiceImpl(
    private val postRepository: PostRepository,
    private val commentRepository: CommentRepository,
    private val userRepository: UserRepository,
    private val securityService: SecurityService
) : CommentService {

    @Transactional
    override fun createComment(
        postId: Long,
        request: CommentCreateRequest
    ): CommentResponse {
        val post = postRepository.findByIdOrNull(postId)
            ?: throw ModelNotFoundException("post", postId)

        val comment = CommentEntity(
            content = request.content,
            post = post,
            user = user

        val savedComment = commentRepository.save(comment)

        return savedComment.toResponse()
    }

    @Transactional
    override fun deleteComment(
        postId: Int,
        commentId: Int,
        userPrincipal: UserPrincipal
    ) {
        val post = postRepository.findByIdOrNull(postId)
            ?: throw ModelNotFoundException("post", postId)
        val comment = commentRepository.findByIdOrNull(commentId)
            ?: throw ModelNotFoundException("Comment", commentId)
        val user = userRepository.findByIdOrNull(userPrincipal.id)
            ?: throw ModelNotFoundException("user", userPrincipal.id)

        securityService.chkUserId(userPrincipal, user.id!!)
        commentRepository.delete(comment)
        postRepository.save(post)
    }

    @Transactional
    override fun updateComment(
        postId: Int,
        commentId: Int,
        userPrincipal: UserPrincipal,
        request: CommentUpdateRequest
    ): CommentResponse {
        val post = postRepository.findByIdOrNull(postId)
            ?: throw ModelNotFoundException("post", postId)
        val comment = commentRepository.findByIdOrNull(commentId)
            ?: throw ModelNotFoundException("Comment", commentId)
        val user = userRepository.findByIdOrNull(userPrincipal.id)
            ?: throw ModelNotFoundException("user", userPrincipal.id)

        securityService.chkUserId(userPrincipal, user.id!!)
        comment.content = request.content
        val updatedComment = commentRepository.save(comment)
        postRepository.save(post)

        return updatedComment.toResponse()
    }

    @Transactional
    override fun getCommentListByPostId(
        postId: Int
    ): List<CommentResponse> {
        val post = postRepository.findByIdOrNull(postId)
            ?: throw ModelNotFoundException("Post", postId)
        return commentRepository.findByPostId(post.id!!).map { it.toResponse() }
    }
}

fun CommentEntity.toResponse(): CommentResponse {
    return CommentResponse(
        id = id,
        content = content,
        nickname = user.nickName,
        createdAt = createdAt
    )
}