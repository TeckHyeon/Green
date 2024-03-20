package com.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.board.domain.MenuVo;

@Mapper
public interface MenuMapper {

	public void insertMenu(MenuVo menuVo);
	public List<MenuVo> viewMenu();
	public void updateMenu(MenuVo menuVo);
	public MenuVo menuDetail(int menu_seq);
	public void DeleteMenu(MenuVo menuVo);
}









