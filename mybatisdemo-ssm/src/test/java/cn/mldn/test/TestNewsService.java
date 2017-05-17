package cn.mldn.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.mldn.service.INewsService;
import cn.mldn.vo.News;
import junit.framework.TestCase;
@ContextConfiguration(locations={"classpath:spring/spring-common.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestNewsService {
	@Resource
	private INewsService newsService;
	@Test
	public void testList() {
		List<News> all = this.newsService.list(1, 10, "title", "");
		System.out.println(all);
		TestCase.assertTrue(all.size() > 0);
	}
	@Test
	public void testAdd() {
		News vo = new News();
		vo.setNote("dodod");
		vo.setTitle("xyxyxxy");
		TestCase.assertTrue(this.newsService.add(vo));
	}
}
