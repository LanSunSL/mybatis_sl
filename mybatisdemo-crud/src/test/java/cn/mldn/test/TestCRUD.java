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
	@Test
	public void testUpdate() {
		News vo = new News();
		vo.setNid(13L);
		vo.setTitle("abcdefg");
		vo.setNote("hahahaha");
		int count = MyBatisSessionFactory.getSession().update("cn.mldn.mapping.NewsNS.doUpdate", vo);
		MyBatisSessionFactory.getSession().commit();
		MyBatisSessionFactory.close();
		System.out.println(vo);
		TestCase.assertTrue(count == 1);
	}
	@Test
	public void testDelete() {
		int count = MyBatisSessionFactory.getSession().delete("cn.mldn.mapping.NewsNS.doRemove", 8L);
		MyBatisSessionFactory.getSession().commit();
		MyBatisSessionFactory.close();
		System.out.println(count);
		TestCase.assertEquals(count, 1);
	}
}
