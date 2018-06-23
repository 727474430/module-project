package com.raindrop.module.controller;

import com.raindrop.module.entity.User;
import com.raindrop.module.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @name: com.raindrop.module.controller.UserController.java
 * @description: 用户Controller层
 * @author: Wang Liang
 * @create Time: 2018/6/21 19:11
 */
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * 列表查询
	 *
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<User> index() {
		return userService.listAll();
	}

	/**
	 * 通过主键查询
	 *
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User get(@PathVariable("id") Long id) {
		return userService.selectOne(id);
	}

	/**
	 * 新增用户
	 *
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public User add(User user) {
		userService.add(user);
		return user;
	}

	/**
	 * 更新用户
	 *
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public User update(User user) {
		userService.update(user);
		return user;
	}

	/**
	 * 通过主键删除
	 *
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("id") Long id) {
		int row = userService.delete(id);
		return row > 0 ? "delete success" : "delete failed";
	}

}
