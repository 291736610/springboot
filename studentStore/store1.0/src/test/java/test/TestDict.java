package test;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.mapper.DictMapper;

public class TestDict {
	@Test
	public void testDistrict(){
		//1.获取Spring容器对象
		AbstractApplicationContext ac = 
				new ClassPathXmlApplicationContext(
						"application-dao.xml");
		//2.获取bean对象
		DictMapper dm = 
					ac.getBean("dictMapper",DictMapper.class);
		System.out.println(
				dm.selectByProvinceCode("130000"));	
		System.out.println(
				dm.selectByCityCode("130100"));
		System.out.println(
				dm.selectByAreaCode("130102"));
	}
	
	@Test
	public void testSelectArea(){
		//1.获取Spring容器对象
		AbstractApplicationContext ac = 
		new ClassPathXmlApplicationContext(
				"application-dao.xml");
		//2.获取bean对象
		DictMapper dm = 
				ac.getBean("dictMapper",DictMapper.class);
		System.out.println(
				dm.selectArea("130100"));
		ac.close();
		
	}
	@Test
	public void testSelectCity(){
	//1.获取容器对象
		AbstractApplicationContext ac = 
			new ClassPathXmlApplicationContext(
				"application-dao.xml");
	//2.获取bean对象
		DictMapper dm = 
				ac.getBean("dictMapper",
						DictMapper.class);
		System.out.println(
				dm.selectCity("130000"));
		ac.close();
					
	}
	@Test
	public void testSelectProvince(){
		//1.获取容器对象
		AbstractApplicationContext ac = 
		new ClassPathXmlApplicationContext(
				"application-dao.xml");
		//2.获取bean对象
		DictMapper dm = 
				ac.getBean("dictMapper",
						DictMapper.class);
		System.out.println(dm.selectProvince());
		ac.close();
	}

}








