package cn.mldn.mybatisdemo.base;

import java.io.InputStream;
import java.util.Date;
import java.util.Random;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.mldn.mybatisdemo.vo.Member;

public class TestMemberAdd {

	@Test
	public void testInsert() {
		try {
			// 1、获取mybatis的核心配置文件，取得了此文件就表示可以取得连接和映射文件信息
			InputStream inputStream = Resources
			.getResourceAsStream("mybatis/mybatis.cfg.xml");
			// 2、获取SqlSessionFactory程序类对象，通过此类对象可以取得MyBatis的Session对象
			// 3、需要根据mybatis.cfg.xml文件的内容才可以创建SqlSessionFactory工厂类
			SqlSessionFactory factory = new SqlSessionFactoryBuilder()
			.build(inputStream);
			// 4、创建Session对象
			SqlSession session = factory.openSession(); // 有了此对象后才可以进行数据操作
			// 5、实现数据保存
			Member vo = new Member();
			vo.setMid("mldn - " + new Random().nextInt(1000));
			vo.setName("测试名字");
			vo.setAge(19);
			vo.setBirthday(new Date());
			vo.setSalary(1.1);
			vo.setNote("是个好人。");
			// 6、进行数据保存，第一个参数为命名空间的名称，第二个参数是VO类对象；
			System.out.println(
			session.insert("cn.mldn.mapping.MemberNS.doCreate", vo));
			// 7、要进行事务的提交处理
			session.commit(); // 默认事务是开启的，所以必须自己提交事务
			// 8、关闭连接
			session.close();
			inputStream.close();
			} catch (Exception e) {
			e.printStackTrace();
			}
	}

}
