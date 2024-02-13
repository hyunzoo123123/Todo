package org.example.board.domain.post.service

import org.example.board.domain.post.dto.PostCreateRequest
import org.example.board.domain.post.dto.PostResponse
import org.example.board.domain.post.dto.PostUpdateRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable

interface PostService {
    fun getPostList(postId: Long): List<PostResponse>
    fun getPost(postId: Long): PostResponse
    fun createPost(
        request: PostCreateRequest
    ): PostResponse

    fun updatePost(
        postId: Long,
        request: PostUpdateRequest
    ): PostResponse

    fun deletePost(postId: Long)
}