package org.lzh.demo.ssm.service.impl;

import javax.annotation.Resource;

import org.lzh.demo.ssm.IDao.IUserDao;
import org.lzh.demo.ssm.domain.User;
import org.lzh.demo.ssm.service.IUserService;

public class UserServiceImpl implements IUserService {
	@Resource  
    private IUserDao userDao;  
    @Override  
    public User getUserById(int userId) {  
        // TODO Auto-generated method stub  
        return this.userDao.selectByPrimaryKey(userId);  
	}

}
