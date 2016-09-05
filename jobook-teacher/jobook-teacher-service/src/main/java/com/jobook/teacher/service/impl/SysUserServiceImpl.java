package com.jobook.teacher.service.impl;


import com.jobook.teacher.mapper.SysUserMapper;
import com.jobook.teacher.pojo.SysUser;
import com.jobook.teacher.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysUserServiceImpl implements SysUserService {
	
	@Resource
	private SysUserMapper sysUserMapper;


	@Override
	public SysUser getById(Integer id) {
		return sysUserMapper.selectByPrimaryKey(id);
	}
}
