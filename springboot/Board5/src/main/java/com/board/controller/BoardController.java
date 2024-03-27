package com.board.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.board.domain.BoardVo;
import com.board.mapper.BoardMapper;
import com.board.menus.domain.MenuVo;
import com.board.menus.mapper.MenuMapper;
import com.board.user.domain.UserVo;

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
	public ModelAndView list(MenuVo menuVo) {
		// 목록 조회
		List<MenuVo> menuList = menuMapper.getMenuList();
		List<BoardVo> boardList = boardMapper.getBoardList(menuVo);
		String menu_id = menuVo.getMenu_id();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/list");
		mv.addObject("menu_id", menu_id);
		mv.addObject("boardList", boardList);
		mv.addObject("menuList", menuList);

		return mv;
	}

	@RequestMapping("/writeForm")
	public ModelAndView writeForm(MenuVo menuVo) {
		ModelAndView mv = new ModelAndView();
		String menu_id = menuVo.getMenu_id();
		mv.addObject("menu_id", menu_id);
		log.info(menu_id);
		mv.setViewName("board/write");
		return mv;

	}

	// menu_id = MENU01, title, writer, content
	@RequestMapping("/write")
	public ModelAndView write(BoardVo boardVo) {
		boardMapper.insertBoard(boardVo);
		String menu_id = boardVo.getMenu_id();
		ModelAndView mv = new ModelAndView();
		log.info("boardVo = {}", boardVo);
		mv.setViewName("redirect:/board/list?menu_id=" + menu_id);
		return mv;
	}

	@RequestMapping("/view")
	public ModelAndView view(BoardVo boardVo) {
		// 메뉴목록 조회
				List<MenuVo>  menuList =  menuMapper.getMenuList(); 
				
				// 조회수 증가( 현재 bno 의 HIT = HIT + 1 )
				boardMapper.incHit( boardVo );
				
				//  bno 로 조회한 게시글 정보
				BoardVo       vo       =  boardMapper.viewBoard( boardVo  );   
				
				// vo.content 안의 \n 을 '<br>' 로 변경한다
				String   content  =  vo.getContent();  
				if(content != null) {
					content           =  content.replace("\n", "<br>");		
					vo.setContent(  content  );
				}
						
				ModelAndView  mv  =  new  ModelAndView();
				mv.addObject("menuList",  menuList );
				mv.addObject("vo", vo);
				mv.setViewName("board/view");
				return  mv;
	}

	@RequestMapping("/updateform")
	public ModelAndView updateform(BoardVo boardVo) {
		ModelAndView mv = new ModelAndView();
		boardVo = boardMapper.viewBoard(boardVo);
		String menu_id = boardVo.getMenu_id();
		mv.addObject("menu_id", menu_id);
		mv.addObject("board", boardVo);
		mv.setViewName("board/update");
		return mv;

	}

	@RequestMapping("/update")
	public ModelAndView update(BoardVo boardVo) {
		ModelAndView mv = new ModelAndView();
		boardMapper.updateboard(boardVo);
		String menu_id = boardVo.getMenu_id();
		mv.setViewName("redirect:/board/list?menu_id=" + menu_id);
		return mv;

	}

}
