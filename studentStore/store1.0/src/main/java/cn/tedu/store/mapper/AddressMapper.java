package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.bean.Address;

public interface AddressMapper {
	/**
	 * 插入收货人信息
	 * @param address
	 */
	void insertAddress(Address address);
	/**
	 * 查询用户的收货地址
	 * @param uid
	 * @return 返回list
	 */
	List<Address> selectByUid(Integer uid);
	/**
	 * 把所有的地址isDefault修改为0
	 * @param uid
	 * @return
	 */
	Integer updateByUid(Integer uid);
	/**
	 * 把指定id的isDefault修改为1
	 * @param id
	 * @return
	 */
	Integer updateById(Integer id);
	/**
	 * 根据id查询收货人信息
	 * @param id
	 * @return
	 */
	Address selectById(Integer id);
	/**
	 * 根据id修改收货人地址信息
	 * @param address
	 */
	void updateAddressById(Address address);
	/**
	 * 删除收货人信息
	 * @param id
	 */
	void deleteById(Integer id);
	
}







