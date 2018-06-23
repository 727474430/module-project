package com.raindrop.module.service.impl;

import com.raindrop.module.dao.UserDao;
import com.raindrop.module.entity.User;
import com.raindrop.module.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @name: com.raindrop.module.service.impl.UserServiceImpl.java
 * @description: 用户Service实现
 * @author: Wang Liang
 * @create Time: 2018/6/22 16:38
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	/**
	 * 查询全部用户
	 *
	 * @return
	 */
	@Override
	public List<User> listAll() {
		return userDao.listAll();
	}

	/**
	 * 通过主键查询
	 *
	 * @param id
	 * @return
	 */
	@Override
	public User selectOne(Long id) {
		return userDao.selectByPrimaryKey(id);
	}

	/**
	 * 新增用户
	 *
	 * @param user
	 * @return
	 */
	@Override
	public int add(User user) {
		return userDao.insertSelective(user);
	}

	/**
	 * 更新用户
	 *
	 * @param user
	 * @return
	 */
	@Override
	public int update(User user) {
		return userDao.updateByPrimaryKeySelective(user);
	}

	/**
	 * 通过主键删除
	 *
	 * @param id
	 * @return
	 */
	@Override
	public int delete(Long id) {
		return userDao.deleteByPrimaryKey(id);
	}

}
