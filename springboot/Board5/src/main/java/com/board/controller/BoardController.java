package com.board.controller;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.board.domain.BoardVo;
import com.board.mapper.BoardMapper;
import com.board.menus.domain.MenuVo;
import com.board.menus.mapper.MenuMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardMapper boardMapper;
	@Autowired
	private MenuMapper menuMapper;

	// /Users/List
	@RequestMapping("/list")
	public ModelAndView list(BoardVo boardVo) {
		// 목록 조회
		ModelAndView mv = new ModelAndView();
		List<BoardVo> boardList = boardMapper.getBoardList(boardVo);
		List<MenuVo> menuList = menuMapper.getMenuList();
		log.info("boardList = {}", boardList);
		log.info("menuList = {}", menuList);
		mv.setViewName("board/list");
		mv.addObject("boardList", boardList);
		mv.addObject("menuList", menuList);

		return mv;
	}
	@RequestMapping("/writeForm")
	public ModelAndView writeForm(BoardVo boardVo) {
		ModelAndView mv = new ModelAndView();
		List<BoardVo> boardList = boardMapper.getBoardList(boardVo);
		mv.addObject("boardList", boardList);
		LocalDateTime today = LocalDateTime.now();
		String now = today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSSS"));
		DayOfWeek wkday = today.getDayOfWeek();
		now += " " + wkday;
		mv.addObject("now", now);
		mv.setViewName("board/write");
		return mv;

	}
	
	@RequestMapping("/write")
	public ModelAndView write(BoardVo boardVo, @RequestParam("menu_id") String menu_id) {
		log.info(menu_id);
		boardVo.setMenu_id(menu_id);
		boardMapper.insertBoard(boardVo);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/board/list");
		return mv;
	}
}
