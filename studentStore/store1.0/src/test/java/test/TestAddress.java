package test;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.Address;
import cn.tedu.store.mapper.AddressMapper;
import cn.tedu.store.service.IAddressService;

public class TestAddress {
	@Test
	public void testDelete(){
	//1.获取Spring容器对象
		AbstractApplicationContext ac = 
			new ClassPathXmlApplicationContext(
			"application-dao.xml",
			"application-service.xml");
		AddressMapper am = 
				ac.getBean("addressMapper",
						AddressMapper.class);
		am.deleteById(5);
	}
	@Test
	public void testUpdateAddress(){
		//1.获取Spring容器对象
		AbstractApplicationContext ac = 
						new ClassPathXmlApplicationContext(
							"application-dao.xml",
							"application-service.xml");
		IAddressService as = 
				ac.getBean("addressService",
						IAddressService.class);
		Address address = new Address();
		address.setId(1);
		address.setRecvName("小黑");
		address.setRecvProvince("140000");
		address.setRecvCity("140100");
		address.setRecvArea("140105");
		address.setRecvAddress("1803教室");
		address.setRecvPhone("13088138000");
		address.setRecvTel("110");
		address.setRecvZip("000000");
		address.setRecvTag("宿舍");
		as.updateAddress(address);
	}
	@Test
	public void testUpdateById(){
	//1.获取Spring容器对象
		AbstractApplicationContext ac = 
				new ClassPathXmlApplicationContext(
					"application-dao.xml",
					"application-service.xml");
		AddressMapper am = 
				ac.getBean("addressMapper",AddressMapper.class);
		Address address = new Address();
		address.setId(3);
		address.setRecvName("小黑");
		address.setRecvProvince("130000");
		address.setRecvCity("130100");
		address.setRecvArea("130102");
		address.setRecvDistrict("河北省石家庄市长安区");
		address.setRecvAddress("1803教室");
		address.setRecvPhone("13088138000");
		address.setRecvTel("110");
		address.setRecvZip("000000");
		address.setRecvTag("宿舍");
		am.updateAddressById(address);	
	}
	@Test
	public void testSelectById(){
	//1.获取Spring容器对象
	AbstractApplicationContext ac = 
			new ClassPathXmlApplicationContext(
				"application-dao.xml",
				"application-service.xml");
	AddressMapper am = 
			ac.getBean("addressMapper",AddressMapper.class);
	System.out.println(
			am.selectById(1));
	ac.close();
	
	}
	@Test
	public void testSetDefault(){
	//1.获取Spring容器对象
	AbstractApplicationContext ac = 
			new ClassPathXmlApplicationContext(
			"application-dao.xml",
			"application-service.xml");
	IAddressService as = 
		ac.getBean("addressService",IAddressService.class);
		
	as.setDefault(5, 5);
	ac.close();
	
	}
	@Test
	public void testUpdate(){
	//1.获取Spring容器对象
		AbstractApplicationContext ac = 
			new ClassPathXmlApplicationContext(
					"application-dao.xml",
					"application-service.xml");
		AddressMapper am = 
			ac.getBean("addressMapper",AddressMapper.class);
		System.out.println(
				am.updateByUid(2));
		System.out.println(
				am.updateById(2));
		ac.close();
	}
	@Test
	public void testAddAddress(){
	//1.获取Spring容器对象
	AbstractApplicationContext ac = 
		new ClassPathXmlApplicationContext(
				"application-dao.xml",
				"application-service.xml");
	//2.获取bean对象	
		IAddressService as = 
			ac.getBean("addressService",
					IAddressService.class);
		Address address = new Address();
		address.setUid(2);
		address.setRecvName("张三");
		address.setRecvProvince("130000");
		address.setRecvCity("130100");
		address.setRecvArea("130102");
		address.setRecvAddress("中鼎8层");
		address.setRecvPhone("13800138000");
		address.setRecvTel("10086");
		address.setRecvTag("公司");
		as.addAddress(address);
		ac.close();
	}
	@Test
	public void testSelectByUid(){
	//1.获取Spring容器对象
		AbstractApplicationContext ac = 
		new ClassPathXmlApplicationContext(
				"application-dao.xml");
	//2.获取bean对象
		AddressMapper am = 
			ac.getBean("addressMapper",AddressMapper.class);
		System.out.println(
				am.selectByUid(2));
		ac.close();
	}
	@Test
	public void testInsertAddress(){
		//1.获取Spring容器对象
		AbstractApplicationContext ac = 
		new ClassPathXmlApplicationContext(
				"application-dao.xml");
		//2.获取bean对象
		AddressMapper am = 
			ac.getBean("addressMapper",AddressMapper.class);
		Address address = new Address();
		address.setUid(2);
		address.setRecvName("admin");
		address.setRecvProvince("130000");
		address.setRecvCity("130100");
		address.setRecvArea("130102");
		address.setRecvDistrict("河北省石家庄市长安区");
		address.setRecvAddress("中鼎7层");
		address.setRecvPhone("13800138000");
		address.setRecvTel("10086");
		address.setRecvZip("100000");
		address.setRecvTag("家");
		address.setIsDefault(1);
		am.insertAddress(address);
		ac.close();
	}

}









