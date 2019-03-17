package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.vo.CartVo;

public interface CartMapper {
	/**
	 * 插入购物车数据
	 * @param cart
	 */
	void insertCart(Cart cart);
	/**
	 * 查询用户的购物车 商品
	 * @param uid
	 * @return
	 */
	List<CartVo> selectByUid(Integer uid);
	/**
	 * 批量删除
	 * @param ids
	 */
	void deleteByIds(Integer[] ids);
	/**
	 * 单行删除
	 * @param id
	 */
	void deleteById(Integer id);
	/**
	 * 修改数量
	 * @param id
	 * @param num
	 */
	void updateById(
			@Param("id") Integer id,
			@Param("num") Integer num);
}











