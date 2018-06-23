package com.raindrop.module.service;

import com.raindrop.module.entity.User;

import java.util.List;

/**
 * @name: UserService.java
 * @description: 用户Service接口
 * @author: Wang Liang
 * @create Time: 2018/6/21 19:12
 */
public interface UserService {

	/**
	 * 查询全部用户
	 *
	 * @return
	 */
	List<User> listAll();

	/**
	 * 通过主键查询
	 *
	 * @param id
	 */
	User selectOne(Long id);

	/**
	 * 新增用户
	 *
	 * @param user
	 * @return
	 */
	int add(User user);

	/**
	 * 更新用户
	 *
	 * @param user
	 * @return
	 */
	int update(User user);

	/**
	 * 通过主键删除
	 *
	 * @param id
	 * @return
	 */
	int delete(Long id);

}
