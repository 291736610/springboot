package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.Goods;

public interface GoodsMapper {
	/**
	 * 查询商品信息
	 * @param categoryId
	 * @param offset
	 * @param count
	 * @return
	 */
	List<Goods> selectByCategoryId(
		@Param("categoryId") Integer categoryId,
		@Param("offset") Integer offset,
		@Param("count") Integer count);
	
	/**
	 * 查询商品的数量
	 * @param categoryId
	 * @return
	 */
	Integer selectCount(Integer categoryId);
	/**
	 * 查询商品信息
	 * @param id
	 * @return
	 */
	Goods selectById(String id);

}








