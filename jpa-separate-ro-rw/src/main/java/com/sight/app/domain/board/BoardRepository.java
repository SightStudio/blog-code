package com.sight.app.domain.board;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long>, BoardRepositoryCustom {

}

