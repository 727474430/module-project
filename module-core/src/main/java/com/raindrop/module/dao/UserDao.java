package com.raindrop.module.dao;

import com.raindrop.module.entity.User;

import java.util.List;

/**
 * @name: com.raindrop.module.dao.UserDao.java
 * @description:
 * @author: Wang Liang 
 * @create Time: 2018/6/23 9:58
 */
public interface UserDao {

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
	 * @return
	 */
	User selectByPrimaryKey(Long id);

    /**
     * 新增用户
     *
     * @param user
     * @return
     */
    int insertSelective(User user);

	/**
	 * 更新用户
	 *
	 * @param user
	 * @return
	 */
	int updateByPrimaryKeySelective(User user);

	/**
	 * 通过主键删除
	 *
	 * @param id
	 * @return
	 */
	int deleteByPrimaryKey(Long id);

}