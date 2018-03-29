package io.renren.modules.generator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.renren.modules.generator.dao.BusResourcesDao;
import io.renren.modules.generator.entity.BusResourcesEntity;
import io.renren.modules.generator.service.BusResourcesService;



@Service("busResourcesService")
public class BusResourcesServiceImpl implements BusResourcesService {
	@Autowired
	private BusResourcesDao busResourcesDao;
	
	@Override
	public BusResourcesEntity queryObject(Long id){
		return busResourcesDao.queryObject(id);
	}
	
	@Override
	public List<BusResourcesEntity> queryList(Map<String, Object> map){
		return busResourcesDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return busResourcesDao.queryTotal(map);
	}
	
	@Override
	public void save(BusResourcesEntity busResources){
		busResourcesDao.save(busResources);
	}
	
	@Override
	public void update(BusResourcesEntity busResources){
		busResourcesDao.update(busResources);
	}
	
	@Override
	public void delete(Long id){
		busResourcesDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		busResourcesDao.deleteBatch(ids);
	}
	
}
