package cn.mldn.test;

import org.junit.Test;

import cn.mldn.util.MyBatisSessionFactory;
import cn.mldn.vo.News;
import junit.framework.TestCase;

public class TestCRUD {

	@Test
	public void testInsert() {
		News vo = new News();
		vo.setTitle("user");
		vo.setNote("shiro");
		int count = MyBatisSessionFactory.getSession().insert("cn.mldn.mapping.NewsNS.doCreate", vo);
		MyBatisSessionFactory.getSession().commit();
		MyBatisSessionFactory.close();
		System.out.println(vo);
		TestCase.assertTrue(count == 1);
	}

}
