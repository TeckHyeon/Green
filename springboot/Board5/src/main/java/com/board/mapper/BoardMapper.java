package com.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.board.domain.BoardVo;
import com.board.menus.domain.MenuVo;

@Mapper
public interface BoardMapper {

	List<BoardVo> getBoardList(MenuVo menuVo);
	List<MenuVo> getMenuId(MenuVo menuVo);
	void insertBoard(BoardVo boardvo);
	BoardVo viewBoard(BoardVo boardVo);
	void updateboard(BoardVo boardVo);
	void incHit(BoardVo boardVo);


}
