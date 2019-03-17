package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.Goods;

public interface IGoodsService {
	/**
	 * 查询商品信息
	 * @param categoryId
	 * @param offset
	 * @param count
	 * @return
	 */
	List<Goods> getByCategoryId(
			Integer categoryId,
			Integer offset,
			Integer count);
	/**
	 * 获取商品的数量
	 * @param categoryId
	 * @return
	 */
	Integer getCount(Integer categoryId);
	/**
	 * 获取商品对象
	 * @param id
	 * @return
	 */
	Goods getById(String id);
}








