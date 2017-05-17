package cn.mldn.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import cn.mldn.dao.INewsDAO;
import cn.mldn.vo.News;
@Repository
public class NewsDAOImpl implements INewsDAO {
	@Resource
	private SqlSessionFactory factory;
	@Override
	public boolean doCreate(News vo) {
		return this.factory.openSession().insert("cn.mldn.mapping.NewsNS.doCreate", vo) > 0;
	}

	@Override
	public List<News> findAllBySplit(Map<String, Object> map) {
		
		return this.factory.openSession().selectList("cn.mldn.mapping.NewsNS.findAllSplit", map);
	}

}
