package cn.tedu.store.service;

import cn.tedu.store.bean.User;

public interface IUserService {
	/**
	 * 添加用户信息
	 * @param user
	 */
	void addUser(User user);
	/**
	 * 验证邮箱是否存在
	 * @param email
	 * @return：如果存在，返回true；
	 * 			如果不存在，返回false
	 */
	boolean checkEmail(String email);
	/**
	 * 验证电话是否存在
	 * @param phone
	 * @return：如果存在，返回true；
	 * 			如果不存在，返回false
	 */
	boolean checkPhone(String phone);
	/**
	 * 验证用户是否存在
	 * @param username
	 * @return  如果存在，返回true；
	 * 			如果不存在，返回false
	 */
	boolean checkUsername(String username);
	/**
	 * 实现用户登录
	 * @param username
	 * @param password
	 * @return ：如果登录成功，返回user对象；
	 * 	登录不成功，抛出异常：账号错误；密码不匹配
	 */
	User login(String username,String password);
	/**
	 * 修改密码
	 * @param id
	 * @param oldPwd
	 * @param newPwd
	 */
	void changePassword(Integer id,
			String oldPwd,String newPwd);
	/**
	 * 修改个人信息
	 * @param id
	 * @param username
	 * @param gender
	 * @param email
	 * @param phone
	 */
	void updateUser(Integer id,String username,
			Integer gender,String email,String phone);
	/**
	 * 通过id查询用户信息
	 * @param id
	 * @return 如果存在，返回user对象
	 * 			如果不存在，返回null
	 */
	User getUserById(Integer id);
	/**
	 * 修改头像
	 * @param id
	 * @param image
	 */
	void updImage(Integer id,String image);
}









