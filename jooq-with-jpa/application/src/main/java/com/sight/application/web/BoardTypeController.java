package com.sight.application.web;

import com.sight.application.app.domain.board.type.BoardTypeService;
import com.sight.application.dto.BoardTypeDto;
import com.sight.entity.BoardType;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board-type")
public class BoardTypeController {

  private final BoardTypeService boardTypeService;

  @GetMapping
  public List<BoardTypeDto> getBoardTypeLike(@RequestParam String keyword) {
    return boardTypeService.getBoardTypeByKeywordLike(keyword);
  }

}
