package com.jobook.account.controller;

import com.jobook.account.pojo.SysUser;
import com.jobook.account.service.SysUserService;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;


@Controller
@RequestMapping("/sysUserController")
public class SysUserController {
	
	private static final Logger LOG = LoggerFactory.getLogger(SysUserController.class);
	
	@Resource
	private SysUserService sysUserService;
	
	@RequestMapping("/showUserToJspById/{userId}")
	public String showUser(Model model,@PathVariable("userId") Integer userId){
		SysUser user = this.sysUserService.getById(userId);
		model.addAttribute("user", user);
		return "showUser";
	}
	
	@RequestMapping("/showUserToJSONById/{userId}")
	@ResponseBody
	public SysUser showUser(@PathVariable("userId") Integer userId){
		SysUser user = sysUserService.getById(userId);
		//	设置ehcahe
		CacheManager cacheManager = CacheManager.create();
		Cache accountCache = cacheManager.getCache("accountCache");
		accountCache.put(new Element(user.getPhone(), user));
		return user;
	}

	@RequestMapping("/validAccountToJSONByPhone/{phone}")
	@ResponseBody
	public SysUser validAccount(@PathVariable("phone") String phone){
		//	读取cahe
		CacheManager cacheManager = CacheManager.create();
		Cache accountCache = cacheManager.getCache("accountCache");
		Element element = accountCache.get(phone);
		SysUser user = null;
		//	如果缓存存在cache中,刷新cache
		if (element != null) {
			user = (SysUser) element.getObjectValue();
			accountCache.remove(phone);
			accountCache.put(new Element(user.getPhone(), user));
		}
		return user;
	}
	
	
	@RequestMapping("/test-logback")
	@ResponseBody
	public Date testLogback(){
		LOG.trace("-----------------------------------trace");
		LOG.debug("-----------------------------------debug");
		LOG.info("-----------------------------------info");
		LOG.warn("-----------------------------------warn");
		LOG.error("-----------------------------------error");
		return new Date();
	}
	



}
