package com.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.board.domain.BoardVo;
import com.board.menus.domain.MenuVo;
import com.board.user.domain.UserVo;

@Mapper
public interface BoardMapper {

	List<BoardVo> getBoardList(BoardVo boardvo);

	void insertBoard(BoardVo boardvo);


}
