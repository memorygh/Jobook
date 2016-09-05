package com.jobook.teacher.controller;


import com.jobook.teacher.pojo.SysUser;
import com.jobook.teacher.service.SysUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/sysUserController")
public class SysUserController {
	@Resource
	private SysUserService sysUserService;
	
	@RequestMapping("/showUserToJspById/{userId}")
	public String showUser(Model model, @PathVariable("userId") Integer userId){
		SysUser user = this.sysUserService.getById(userId);
		model.addAttribute("user", user);
		return "showUser";
	}
	
	@RequestMapping("/showUserToJSONById/{userId}")
	@ResponseBody
	public SysUser showUser(@PathVariable("userId") Integer userId){
		SysUser user = sysUserService.getById(userId);
		return user;
	}
	
	



}
