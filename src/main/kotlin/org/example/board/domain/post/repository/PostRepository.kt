package org.example.board.domain.post.repository

import org.example.board.domain.post.model.PostEntity
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository : JpaRepository<PostEntity, Long> {
    fun readPost(PostId:Long): List<PostEntity>
}