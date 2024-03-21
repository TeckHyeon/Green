package com.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	@RequestMapping("/WriteForm2")
	public  String  WriteForm2() {
		
		return  "menus/writeform2";    
	}
	
	@RequestMapping("/Write")
	public String Write(MenuVo menuVo) {
	    menuMapper.insertMenu(menuVo);
	    return "redirect:/Menus/List";   
	}
	@RequestMapping("/Write2")
	public String Write2(MenuVo menuVo) {
		menuMapper.insertQuick(menuVo);
		return "redirect:/Menus/List";   
	}
	@RequestMapping("/List")
	public  String  List(Model model) {
		List<MenuVo> lists = menuMapper.viewMenu();
		model.addAttribute("lists",lists);
		return  "menus/list";    
	}
	@RequestMapping("/Delete")
	public String Delete(@RequestParam("menu_seq") int menu_seq, MenuVo menuVo) {
	    menuVo.setMenu_seq(menu_seq);
	    menuMapper.DeleteMenu(menuVo);
	    return "redirect:/Menus/List";
	}
	@RequestMapping("/UpdateForm/{menu_seq}")
	public  String  UpdateForm(@PathVariable("menu_seq") int menu_seq, Model model, MenuVo menuVo) {
		menuVo = menuMapper.menuDetail(menu_seq);
		model.addAttribute("menu", menuVo);
		return  "menus/UpdateForm";    
	}
	@RequestMapping("/Update/{menu_seq}")
	public  String  Update(@PathVariable("menu_seq") int menu_seq, MenuVo menuVo) {
		menuVo.setMenu_seq(menu_seq);
	    menuMapper.updateMenu(menuVo);
		return  "redirect:/Menus/List";    
	}

}
