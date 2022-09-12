package com.sight.application.app.domain.board.type;

import com.sight.entity.BoardType;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardTypeJpaRepository extends JpaRepository<BoardType, Long> {

  List<BoardType> findByCodeNameContaining(String codeName);
}
