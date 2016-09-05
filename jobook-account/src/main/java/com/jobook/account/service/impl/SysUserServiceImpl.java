package com.jobook.account.service.impl;

import com.jobook.account.service.SysUserService;
import org.springframework.stereotype.Service;
import com.jobook.account.mapper.SysUserMapper;
import com.jobook.account.pojo.SysUser;

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
