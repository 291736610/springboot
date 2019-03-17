package cn.tedu.store.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.tedu.store.bean.Address;
//@Transactional表示接口的所有实现类都实现事务
@Transactional
public interface IAddressService {
	/**
	 * 添加收货人地址
	 * @param address
	 */
	void addAddress(Address address);
	/**
	 * 获取收货人地址
	 * @param uid
	 * @return
	 */
	List<Address> getByUid(Integer uid);
	/**
	 * 设置为默认
	 * @param uid
	 * @param id
	 */
	void setDefault(Integer uid,Integer id);
	/**
	 * 根据id获取收货人地址信息
	 * @param id
	 * @return
	 */
	Address getById(Integer id);
	/**
	 * 根据id修改收货人地址
	 * @param address
	 */
	void updateAddress(Address address);
	/**
	 * 删除收货人地址
	 * @param id
	 */
	void removeAddress(Integer id);

}








