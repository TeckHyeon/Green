package com.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.board.domain.MenuVo;
import com.board.mapper.MenuMapper;

@Controller
@RequestMapping("/Menus")
public class MenuController {

	@Autowired
	private MenuMapper menuMapper;
	
	@RequestMapping("/WriteForm")
	public  String  WriteForm() {

		return  "menus/writeform";    
	}
	
	@RequestMapping("/Write")
	public String Write(MenuVo menuVo) {
	    menuMapper.insertMenu(menuVo);
	    return "redirect:/Menus/List";   
	}
	@RequestMapping("/List")
	public  String  List(Model model) {
		List<MenuVo> lists = menuMapper.viewMenu();
		model.addAttribute("lists",lists);
		return  "menus/list";    
	}
	@RequestMapping("/Delete/{menu_seq}")
	public  String  Delete(MenuVo menuVo) {
		menuMapper.DeleteMenu(menuVo);
		return  "redirect:/Menus/List";    
	}
	@RequestMapping("/UpdateForm/{menu_seq}")
	public  String  UpdateForm(@PathVariable("menu_seq") int menu_seq, Model model) {
		MenuVo menuVo = menuMapper.menuDetail(menu_seq);
		model.addAttribute("menu", menuVo);
		return  "menus/UpdateForm";    
	}
	@RequestMapping("/Update/{menu_seq}")
	public  String  Update(MenuVo menuVo) {
		
	    menuMapper.updateMenu(menuVo);
		return  "redirect:/Menus/List";    
	}

}