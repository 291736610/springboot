package test;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.mapper.GoodsMapper;

public class TestGoods {
	@Test
	public void testById(){
		AbstractApplicationContext ac = 
				new ClassPathXmlApplicationContext(
				"application-dao.xml");
			GoodsMapper gm = 
				ac.getBean("goodsMapper",GoodsMapper.class);
			System.out.println(
					gm.selectById("10000000"));
			ac.close();
	}
	@Test
	public void selectcount(){
		AbstractApplicationContext ac = 
			new ClassPathXmlApplicationContext(
			"application-dao.xml");
		GoodsMapper gm = 
			ac.getBean("goodsMapper",GoodsMapper.class);
		System.out.println(
				gm.selectCount(163));
				
	}
	@Test
	public void testSelectByCategoryId(){
		AbstractApplicationContext ac = 
		new ClassPathXmlApplicationContext(
				"application-dao.xml");
		GoodsMapper gm = 
				ac.getBean("goodsMapper",GoodsMapper.class);
		System.out.println(
			gm.selectByCategoryId(163,0, 3));
		ac.close();
		
	}

}






