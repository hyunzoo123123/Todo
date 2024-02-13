package org.example.board.domain.post.service

import org.example.board.domain.post.dto.PostResponse
import org.example.board.domain.post.dto.PostUpdateRequest
import org.example.board.domain.post.model.PostEntity
import org.example.board.domain.post.repository.PostRepository
import org.example.board.domain.user.repository.UserRepository
import org.springdoc.core.service.SecurityService
import org.springframework.stereotype.Service

@Service
class PostServiceImpl(
    private val postRepository: PostRepository,
    private val userRepository: UserRepository,
    private val securityService: SecurityService,
) : PostService {

    override fun getAllPosts(): List<PostResponse> {
        return postRepository.findAll().map {
            it.toResponse()
        }
    }
    override fun getPost(
        postId: Int
    ): PostResponse {
        val post = postRepository.findByIdOrNull(postId)
            ?: throw Exception()
        return post.toResponse()
    }
    override fun createPost(
        request: PostCreateRequest
    ): PostResponse {
        val user = userRepository.findByIdOrNull(userPrincipal.id)
            ?: throw ModelNotFoundException("user", userPrincipal.id)
        val post = PostEntity(
            title = request.title,
            contents = request.contents,
            user = user,
            nickname = user.nickName,
        )
        postRepository.save(post)
        return post.toResponse()
    }
    override fun updatePost(
        postId: Int,
        request: PostUpdateRequest
    ): PostResponse {

        val post = postRepository.findByIdOrNull(postId)
            ?: throw ModelNotFoundException("post", postId)
        val (title, contents) = request
        post.title = title
        post.contents = contents
        return post.toResponse()
    }
    override fun deletePost(
        postId: Int,
    ) {
        val post = postRepository.findByIdOrNull(postId)
            ?: throw ModelNotFoundException("post", postId)
        securityService.chkUserId(post.id!!)
        postRepository.delete(post)
    }
}

fun PostEntity.toResponse(): PostResponse {
    return PostResponse(
        id = id!!,
        createAt = createdAt,
        title = title,
        contents = contents,
    )
}