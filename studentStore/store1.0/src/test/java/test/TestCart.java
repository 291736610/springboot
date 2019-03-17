package test;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.mapper.CartMapper;

public class TestCart {
	@Test
	public void testDeleteById(){
		AbstractApplicationContext ac = 
				new ClassPathXmlApplicationContext(
						"application-dao.xml");
		CartMapper cm = 
				ac.getBean("cartMapper",CartMapper.class);
		cm.deleteById(3);
		ac.close();
		
	}
	@Test
	public void testDeleteByIds(){
		AbstractApplicationContext ac = 
				new ClassPathXmlApplicationContext(
						"application-dao.xml");
		CartMapper cm = 
				ac.getBean("cartMapper",CartMapper.class);
		
		cm.deleteByIds(new Integer[]{5,6});
		ac.close();
	}
	@Test
	public void testSelectByUid(){
		AbstractApplicationContext ac = 
				new ClassPathXmlApplicationContext(
						"application-dao.xml");
		CartMapper cm = 
				ac.getBean("cartMapper",CartMapper.class);
		System.out.println(
				cm.selectByUid(2));	
		ac.close();
	}
	@Test
	public void testInsertCart(){
		AbstractApplicationContext ac = 
		new ClassPathXmlApplicationContext(
				"application-dao.xml");
		CartMapper cm = 
		ac.getBean("cartMapper",CartMapper.class);
		Cart cart = new Cart();
		cart.setUid(2);
		cart.setGoodsId("10000017");
		cart.setNum(1);
		cm.insertCart(cart);
		ac.close();
	}
}








