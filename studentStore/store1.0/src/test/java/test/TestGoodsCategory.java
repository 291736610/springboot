package test;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.mapper.GoodsCategoryMapper;

public class TestGoodsCategory {
	@Test
	public void testSelectByParentId(){
		//1.获取Spring容器
		AbstractApplicationContext ac =  
		new ClassPathXmlApplicationContext(
			"application-dao.xml");
		GoodsCategoryMapper cm = 
			ac.getBean("goodsCategoryMapper",
					GoodsCategoryMapper.class);
		System.out.println(
				cm.selectByParentId(161,0, 3));
		
		System.out.println(
				cm.selectByParentId(162,null,null));
		System.out.println(
				cm.selectByParentId(171,null,null));
		System.out.println(
				cm.selectByParentId(186,null,null));
		ac.close();
	}

}







