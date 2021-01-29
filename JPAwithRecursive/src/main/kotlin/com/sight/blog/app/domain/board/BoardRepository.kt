package com.sight.blog.app.domain.board

import org.springframework.data.jpa.repository.JpaRepository

interface BoardRepository: JpaRepository<Board, Long>