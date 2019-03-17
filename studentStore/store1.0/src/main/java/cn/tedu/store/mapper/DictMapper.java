package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.bean.Area;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Province;

public interface DictMapper {
	/**
	 * 查询所有省份信息
	 * @return
	 */
	List<Province> selectProvince();
	/**
	 * 查询城市信息
	 * @param provinceCode
	 * @return
	 */
	List<City> selectCity(String provinceCode);
	/**
	 * 查询区县信息
	 * @param cityCode
	 * @return
	 */
	List<Area> selectArea(String cityCode);
	/**
	 * 查询省的名称
	 * @param provinceCode
	 * @return
	 */
	String selectByProvinceCode(String provinceCode);
	/**
	 * 查询城市的名称
	 * @param provinceCode
	 * @return
	 */
	String selectByCityCode(String cityCode);
	/**
	 * 查询区县的名称
	 * @param provinceCode
	 * @return
	 */
	String selectByAreaCode(String areaCode);
}






