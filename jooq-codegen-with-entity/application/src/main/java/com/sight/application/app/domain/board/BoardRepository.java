package com.sight.application.app.domain.board;

import com.sight.application.app.dco.OrderBy;
import com.sight.application.app.util.RandomUtil;
import com.sight.application.config.jooq.BaseJooqRepository;
import com.sight.application.config.jooq.TextSearchWildcard;
import com.sight.application.web.BoardRegisterRequest;
import com.sight.entity.Board;
import java.util.ArrayList;
import jooq.jooq_dsl.tables.JAppUser;
import jooq.jooq_dsl.tables.JBoard;
import jooq.jooq_dsl.tables.JBoardType;
import jooq.jooq_dsl.tables.records.JBoardRecord;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class BoardRepository implements BaseJooqRepository {

    private final DSLContext dsl;

    public int bulkRegisterBoard(List<BoardRegisterRequest> boardList) {
        final JBoard board = JBoard.BOARD;
        var insertRows = boardList.stream()
                .map(request -> DSL.row(
                        request.getTitle(),
                        request.getContent(),
                        request.getBoardTypeSeq(),
                        request.getUserSeq(),
                        RandomUtil.getRandomDateTime(
                            LocalDate.of(2015, 11, 12),
                            LocalDate.of(2022, 4, 4)
                        )
                ))
                .collect(Collectors.toList());

        return dsl.insertInto(board,
                board.TITLE,
                board.CONTENT,
                board.BOARD_TYPE_SEQ,
                board.USER_SEQ,
                board.REG_DATE
        ).valuesOfRows(insertRows)
        .execute();
    }

  /**
   * @Deprecated - has bug
   * MappedSuperclass + JPA entity + table wildcard 를 같이 사용 할 경우 버그가 존재함
   */
    public List<Board> getBoardWithPaging_bug(int page, int pageSize) {
      final JBoard board = JBoard.BOARD;
      return dsl.select(board.asterisk())
          .from(board)
          .limit(pageSize)
          .offset(page * pageSize)
          .fetchInto(Board.class);
    }

  /**
   * @Deprecated - works fine
   * MappedSuperclass + JPA entity + No wildcard 의 경우 정상동작
   */
  public List<Board> getBoardWithPaging_wildcard(int page, int pageSize) {
    final JBoard board = JBoard.BOARD;
    return dsl.select()
        .from(board)
        .limit(pageSize)
        .offset(page * pageSize)
        .fetchInto(Board.class);
  }

  public List<Board> getBoardList (BoardSqlSearch search) {
    final JBoard board = JBoard.BOARD;
    return dsl.select()
        .from(board)
        .where (
            likeIfNotEmpty(board.TITLE, search.getTitleKeyword()),
            likeIfNotEmpty(board.CONTENT, search.getContentKeyword()),
            nullableBetween(board.REG_DATE, search.getStartDt(), search.getFinishDt())
        )
        .orderBy(orderByField(board.REG_DATE, search.getOrderBy()))
        .offset(search.getOffsetSize())
        .limit(search.getLimit())
        .fetchInto(Board.class);
  }

  public List<Board> getBoardList_DynamicCondition (BoardSqlSearch search) {
    final JBoard board = JBoard.BOARD;
    return dsl.select()
        .from(board)
        .where (
            likeIfNotEmpty(board.TITLE, search.getTitleKeyword(), TextSearchWildcard.FULL_TEXT),
            likeIfNotEmpty(board.CONTENT, search.getContentKeyword(), TextSearchWildcard.FULL_TEXT),
            nullableBetween(board.REG_DATE, search.getStartDt(), search.getFinishDt())
        )
        .orderBy(orderByField(board.REG_DATE, search.getOrderBy()))
        .offset(search.getOffsetSize())
        .limit(search.getLimit())
        .fetchInto(Board.class);
  }

  public List<BoardDetailDto> getBoardDetailedList_DependentSubquery (BoardSqlSearch search) {
    final JBoard board = JBoard.BOARD;
    final JBoardType boardType = JBoardType.BOARD_TYPE;
    final JAppUser appUser = JAppUser.APP_USER;

    return dsl.select (
          board.BOARD_SEQ,
          board.BOARD_TYPE_SEQ,
          board.USER_SEQ,
          DSL.field(dsl.select(boardType.CODE_NAME).from(boardType).where(boardType.BOARD_TYPE_SEQ.eq(board.BOARD_TYPE_SEQ))),
          DSL.field(dsl.select(appUser.USER_NAME).from(appUser).where(appUser.USER_SEQ.eq(board.USER_SEQ)))
        ).from(board)
        .where (
            likeIfNotEmpty(board.TITLE, search.getTitleKeyword()),
            likeIfNotEmpty(board.CONTENT, search.getContentKeyword()),
            nullableBetween(board.REG_DATE, search.getStartDt(), search.getFinishDt())
        )
        .orderBy(orderByField(board.REG_DATE, search.getOrderBy()))
        .offset(search.getOffsetSize())
        .limit(search.getLimit())
        .fetchInto(BoardDetailDto.class);
  }

  public List<BoardDetailDto> getBoardDetailedList_LeftJoin (BoardSqlSearch search) {
    final JBoard board = JBoard.BOARD;
    final JBoardType boardType = JBoardType.BOARD_TYPE;
    final JAppUser appUser = JAppUser.APP_USER;

    return dsl.select (
            board.BOARD_SEQ,
            board.BOARD_TYPE_SEQ,
            board.USER_SEQ,
            boardType.CODE_NAME,
            appUser.USER_NAME
        ).from(board)
        .leftJoin(boardType)
          .on(eq(board.BOARD_TYPE_SEQ, boardType.BOARD_TYPE_SEQ))
        .leftJoin(appUser)
          .on(eq(board.USER_SEQ, appUser.USER_SEQ))
        .where (
            likeIfNotEmpty(board.TITLE, search.getTitleKeyword()),
            likeIfNotEmpty(board.CONTENT, search.getContentKeyword()),
            nullableBetween(board.REG_DATE, search.getStartDt(), search.getFinishDt())
        )
        .orderBy(orderByField(board.REG_DATE, search.getOrderBy()))
        .offset(search.getOffsetSize())
        .limit(search.getLimit())
        .fetchInto(BoardDetailDto.class);
  }

  public int editBoard (Long boardSeq, BoardSqlEdit edit) {
    JBoard board = JBoard.BOARD;
    JBoardRecord record = new JBoardRecord();

    if (StringUtils.isNotBlank(edit.getTitle())) {
      record.setTitle(edit.getTitle());
    }

    if (StringUtils.isNotBlank(edit.getContent())) {
      record.setContent(edit.getContent());
    }

    return dsl.update(board)
        .set(record)
        .where(board.BOARD_SEQ.eq(boardSeq))
        .execute();
  }
}
