package com.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.board.domain.BoardVo;
import com.board.menus.domain.MenuVo;

@Mapper
public interface BoardMapper {

	List<BoardVo> getBoardList(BoardVo boardvo);
	List<MenuVo> getMenuId(MenuVo menuVo);
	void insertBoard(BoardVo boardvo);


}
